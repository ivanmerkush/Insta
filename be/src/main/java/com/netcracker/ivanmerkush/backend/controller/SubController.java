package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.SubEntity;
import com.netcracker.ivanmerkush.backend.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subs")
public class SubController {
    @Autowired
    SubService subService;

    @GetMapping(value = "/{id}")
    public List<SubEntity> getSubscriptions(@PathVariable(name = "id") Integer id) {
        return subService.getSubcriptions(id);
    }

    @PostMapping()
    public SubEntity addUser(@RequestBody SubEntity bond) {
        return subService.addSub(bond);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable Integer id) {
        subService.deleteSub(id);
    }

    @GetMapping(value ="/host/{id}")
    public Integer countSubscribers(@PathVariable(name = "id") Integer id) {
        return subService.countSubscribers(id);
    }

    @GetMapping(value ="/sub/{id}")
    public Integer countSubscriptions(@PathVariable(name = "id") Integer id) {
        return subService.countSubscriptions(id);
    }

    @GetMapping(value="/host{idHost}/sub{idSub}")
    public Boolean isBondExists(@PathVariable(name = "idHost") Integer idHost, @PathVariable(name = "idSub") Integer idSub) {
        return subService.isBondExists(idHost,idSub);
    }

    @GetMapping(value="/host/{idHost}/sub/{idSub}")
    public SubEntity getBond(@PathVariable(name = "idHost") Integer idHost, @PathVariable(name = "idSub") Integer idSub) {
        return subService.getBond(idHost, idSub);
    }
}
