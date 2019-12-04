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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<SubEntity> getSubscriptions(@PathVariable(name = "id") Integer id) {
        return subService.getSubcriptions(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public SubEntity addUser(@RequestBody SubEntity bond) {
        return subService.addSub(bond);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Integer id) {
        subService.deleteSub(id);
    }

    @RequestMapping(value ="/host{id}", method = RequestMethod.GET)
    public Integer countSubscribers(@PathVariable(name = "id") Integer id) {
        return subService.countSubscribers(id);
    }

    @RequestMapping(value ="/sub{id}", method = RequestMethod.GET)
    public Integer countSubscriptions(@PathVariable(name = "id") Integer id) {
        return subService.countSubscriptions(id);
    }

}
