package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Complaint;
import com.netcracker.ivanmerkush.fapi.models.ComplaintViewModel;
import com.netcracker.ivanmerkush.fapi.models.Reason;

import java.util.List;

public interface ComplaintService {
    List<ComplaintViewModel> getComplaints();
    List<ComplaintViewModel> getComplaintsByReason(String reason);
    List<ComplaintViewModel> getComplaintsByIdAccused(Integer idAccused);
    Complaint saveComplaint(Complaint complaint);
    Boolean isComplaintExists(Integer idProsecutor, Integer idAccused);
    void deleteComplaint(Integer idProsecutor, Integer idAccused);
    void deleteComplaintsByAccuser(Integer idAccuser);
}
