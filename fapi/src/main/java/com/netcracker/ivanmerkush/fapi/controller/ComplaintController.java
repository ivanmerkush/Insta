package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Complaint;
import com.netcracker.ivanmerkush.fapi.models.ComplaintViewModel;
import com.netcracker.ivanmerkush.fapi.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @GetMapping(value="/all")
    public List<ComplaintViewModel> getComplaints() {
        return complaintService.getComplaints();
    }

    @PostMapping()
    public ResponseEntity<Complaint> saveComplaint(@RequestBody Complaint complaint) {
        if (complaint != null) {
            return ResponseEntity.ok(complaintService.saveComplaint(complaint));
        }
        return null;
    }

    @GetMapping(value="/accuser/{id}")
    public ResponseEntity<List<ComplaintViewModel>> getComplaintsByIdAccuser(@PathVariable(name="id") Integer id) {
        return ResponseEntity.ok(complaintService.getComplaintsByIdAccused(id));
    }

    @GetMapping(value="/reason")
    public ResponseEntity<List<ComplaintViewModel>> getComplaints(@RequestParam(name="reason") String reason) {
        return ResponseEntity.ok(complaintService.getComplaintsByReason(reason));
    }

    @GetMapping(value="/prosecutor/{idProsecutor}/accused/{idAccused}")
    public ResponseEntity<Boolean> isComplaintExists(@PathVariable(name = "idProsecutor") Integer idProsecutor, @PathVariable(name = "idAccused") Integer idAccused) {
        return ResponseEntity.ok(complaintService.isComplaintExists(idProsecutor, idAccused));
    }

    @DeleteMapping(value ="/prosecutor/{idProsecutor}/accused/{idAccused}")
    public void deleteComplaint(@PathVariable(name="idProsecutor") Integer idProsecutor,
                                @PathVariable(name="idAccused") Integer idAccused) {
        complaintService.deleteComplaint(idProsecutor, idAccused);
    }
}
