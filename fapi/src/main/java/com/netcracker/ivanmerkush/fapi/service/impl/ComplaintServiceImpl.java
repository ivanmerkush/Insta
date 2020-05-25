package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Complaint;
import com.netcracker.ivanmerkush.fapi.models.ComplaintViewModel;
import com.netcracker.ivanmerkush.fapi.models.Reason;
import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.service.ComplaintService;
import com.netcracker.ivanmerkush.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Autowired
    UserService userService;

    @Override
    public List<ComplaintViewModel> getComplaints() {
        RestTemplate restTemplate = new RestTemplate();
        Complaint[] complaints =  restTemplate.getForObject(backendServerUrl + "/api/complaints/all",
                Complaint[].class);
        return createViewModels(Arrays.asList(complaints));
    }

    @Override
    public List<ComplaintViewModel> getComplaintsByReason(String typeOfReason) {
        Reason reason = Reason.valueOf(typeOfReason.toUpperCase());

        RestTemplate restTemplate = new RestTemplate();
        Complaint[] complaints = restTemplate.getForObject(backendServerUrl + "/api/complaints/reason?reason=" + reason,
                Complaint[].class);
        return createViewModels(Arrays.asList(complaints));
    }

    @Override
    public List<ComplaintViewModel> getComplaintsByIdAccused(Integer idAccused) {
        RestTemplate restTemplate = new RestTemplate();
        Complaint[] complaints =  restTemplate.getForObject(backendServerUrl + "/api/complaints/accused/" + idAccused,
                Complaint[].class);

        return createViewModels(Arrays.asList(complaints));
    }

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/complaints",complaint, Complaint.class).getBody();
    }

    @Override
    public Boolean isComplaintExists(Integer idProsecutor, Integer idAccused) {
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject(backendServerUrl + "api/complaints/prosecutor/"+ idProsecutor + "/accused/"  + idAccused,
                Boolean.class);
        return result;
    }

    @Override
    public void deleteComplaint(Integer idProsecutor, Integer idAccused) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "api/complaints/prosecutor/"+ idProsecutor + "/accused/"  + idAccused);
    }

    @Override
    public void deleteComplaintsByAccuser(Integer idAccuser) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/complaints/accused/" + idAccuser);
    }

    public List<ComplaintViewModel> createViewModels(List<Complaint> complaints){
        List<ComplaintViewModel> result = new ArrayList<>();
        for(Complaint i: complaints) {
            User prosecutor = userService.getUserById(i.getIdProsecutor());
            User accused = userService.getUserById(i.getIdAccused());
            result.add(new ComplaintViewModel(prosecutor.getNickname(), prosecutor.getProfilePhoto(), accused.getNickname(), accused.getProfilePhoto(), i));
        }
        return result;
    }
}
