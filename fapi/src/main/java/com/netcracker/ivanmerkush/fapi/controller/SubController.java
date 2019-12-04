package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Sub;
import com.netcracker.ivanmerkush.fapi.service.SubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subs")
public class SubController {
    private SubService subService;

    public SubController(SubService subService) {
        this.subService = subService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Sub> saveUser(@RequestBody Sub bond/*todo server validation*/) {
        if (bond != null) {
            return ResponseEntity.ok(subService.saveSub(bond));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSub(@PathVariable String id) {
        subService.deleteSub(Long.valueOf(id));
    }

    @RequestMapping(value = "/host{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> countSubscribers(@PathVariable String id) {
        return ResponseEntity.ok(subService.countSubscribers(Long.valueOf(id)));
    }

    @RequestMapping(value = "/sub{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> countSubscriptions(@PathVariable String id) {
        return ResponseEntity.ok(subService.countSubscriptions(Long.valueOf(id)));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<List<Sub>> getSubscriptions(@PathVariable String id) {
        Long idUser = Long.valueOf(id);
        return ResponseEntity.ok(subService.getSubscriptions(idUser));
    }


}
