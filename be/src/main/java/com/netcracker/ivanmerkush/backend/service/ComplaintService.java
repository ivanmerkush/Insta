package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.ComplaintEntity;
import com.netcracker.ivanmerkush.backend.entity.Reason;

import java.util.List;

public interface ComplaintService {
    Iterable<ComplaintEntity> getComplaints();
    List<ComplaintEntity> getComplaintsByReason(Reason reason);
    List<ComplaintEntity> getComplaintsByIdAccused(Integer idAccused);
    ComplaintEntity saveComplaint(ComplaintEntity complaint);
    Boolean isComplaintExists(Integer idProsecutor, Integer idAccused);
    void deleteComplaint(Integer idProsecutor, Integer idAccused);
    void deleteComplaintsByIdAccuser(Integer idAccuser);
}
