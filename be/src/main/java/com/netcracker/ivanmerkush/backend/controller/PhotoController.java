package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.PhotoEntity;
import com.netcracker.ivanmerkush.backend.service.impl.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    PhotoServiceImpl photoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<PhotoEntity> getPhotoForPost(@PathVariable(name = "id") Integer id) {
        return photoService.getPhotoByIdPost(id);
    }
}
