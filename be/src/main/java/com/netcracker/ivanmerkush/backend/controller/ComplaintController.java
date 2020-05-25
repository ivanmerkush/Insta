package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.ComplaintEntity;
import com.netcracker.ivanmerkush.backend.entity.HashtagEntity;
import com.netcracker.ivanmerkush.backend.entity.Reason;
import com.netcracker.ivanmerkush.backend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping(value="/all")
    public List<ComplaintEntity> getComplaints() {
        return (List<ComplaintEntity>) complaintService.getComplaints();
    }

    @PostMapping()
    public ComplaintEntity saveComplaint(@RequestBody ComplaintEntity complaint) {
        return complaintService.saveComplaint(complaint);
    }

    @GetMapping(value="/accused/{id}")
    public List<ComplaintEntity> getComplaintsByIdAccused(@PathVariable(name="id") Integer id) {
        return complaintService.getComplaintsByIdAccused(id);
    }

    @GetMapping(value="/prosecutor/{idProsecutor}/accused/{idAccused}")
    public Boolean isComplaintExists(@PathVariable(name = "idProsecutor") Integer idProsecutor, @PathVariable(name = "idAccused") Integer idAccused) {
        return complaintService.isComplaintExists(idProsecutor, idAccused);
    }

    @GetMapping(value="/reason")
    public List<ComplaintEntity> getComplaintsByReason(@RequestParam(name="reason") Reason reason) {
        return complaintService.getComplaintsByReason(reason);
    }

    @DeleteMapping(value = "/prosecutor/{idProsecutor}/accused/{idAccused}")
    public void deleteComplaint(@PathVariable(name="idProsecutor") Integer idProsecutor,
                                @PathVariable(name="idAccused") Integer idAccused) {
        complaintService.deleteComplaint(idProsecutor, idAccused);
    }

    @DeleteMapping(value = "/accused/{id}")
    public void deleteComplaintsByAccuser(@PathVariable(name="id") Integer id) {
        complaintService.deleteComplaintsByIdAccuser(id);
    }

}
