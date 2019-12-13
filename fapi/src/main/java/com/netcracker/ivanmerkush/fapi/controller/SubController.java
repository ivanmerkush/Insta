package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Sub;
import com.netcracker.ivanmerkush.fapi.service.SubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/subs")
public class SubController {
    private SubService subService;

    public SubController(SubService subService) {
        this.subService = subService;
    }

    @PostMapping()
    public ResponseEntity<Sub> saveUser(@RequestBody Sub bond/*todo server validation*/) {
        if (bond != null) {
            return ResponseEntity.ok(subService.saveSub(bond));
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSub(@PathVariable String id) {
        subService.deleteSub(Integer.valueOf(id));
    }

    @GetMapping(value = "/host{id}")
    public ResponseEntity<Integer> countSubscribers(@PathVariable String id) {
        return ResponseEntity.ok(subService.countSubscribers(Integer.valueOf(id)));
    }

    @GetMapping(value = "/sub{id}")
    public ResponseEntity<Integer> countSubscriptions(@PathVariable String id) {
        return ResponseEntity.ok(subService.countSubscriptions(Integer.valueOf(id)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Sub>> getSubscriptions(@PathVariable String id) {
        return ResponseEntity.ok(subService.getSubscriptions(Integer.valueOf(id)));
    }

    @GetMapping(value= "/host{idHost}/sub{idSub}")
    public ResponseEntity<Boolean> isBondExists(@PathVariable String idHost, @PathVariable String idSub) {
        return ResponseEntity.ok(subService.isBondExists(Integer.valueOf(idHost), Integer.valueOf(idSub)));
    }

    @GetMapping(value="/host/{idHost}/sub/{idSub}")
    public ResponseEntity<Sub> getBond(@PathVariable String idHost, @PathVariable String idSub) {
        return ResponseEntity.ok(subService.getBond(Integer.valueOf(idHost), Integer.valueOf(idSub)));
    }
}
