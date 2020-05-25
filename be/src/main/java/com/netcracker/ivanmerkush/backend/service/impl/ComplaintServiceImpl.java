package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.ComplaintEntity;
import com.netcracker.ivanmerkush.backend.entity.Reason;
import com.netcracker.ivanmerkush.backend.repository.ComplaintRepository;
import com.netcracker.ivanmerkush.backend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Iterable<ComplaintEntity> getComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public List<ComplaintEntity> getComplaintsByReason(Reason reason) {
        return complaintRepository.getComplaintEntitiesByReasonOrderByFillingDateDesc(reason);
    }

    @Override
    public List<ComplaintEntity> getComplaintsByIdAccused(Integer idAccused) {
        return complaintRepository.getComplaintEntitiesByIdAccusedOrderByFillingDateDesc(idAccused);
    }

    @Override
    public ComplaintEntity saveComplaint(ComplaintEntity complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Boolean isComplaintExists(Integer idProsecutor, Integer idAccused) {
        return complaintRepository.existsComplaintEntityByIdProsecutorAndIdAccused(idProsecutor, idAccused);
    }

    @Override
    public void deleteComplaint(Integer idProsecutor, Integer idAccused) {
        complaintRepository.deleteComplaintEntityByIdProsecutorAndIdAccused(idProsecutor, idAccused);
    }

    @Override
    public void deleteComplaintsByIdAccuser(Integer idAccuser) {
        complaintRepository.deleteComplaintEntitiesByIdAccused(idAccuser);
    }
}
