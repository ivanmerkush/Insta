package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.PhotoEntity;
import com.netcracker.ivanmerkush.backend.service.impl.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    PhotoServiceImpl photoService;

    @GetMapping(value = "/{id}")
    public PhotoEntity getPhotoForPost(@PathVariable(name = "id") Integer id) {
        return photoService.getPhotoByIdPost(id);
    }

    @PostMapping()
    public PhotoEntity savePhoto(@RequestBody PhotoEntity photo) {
        return photoService.addPhoto(photo);
    }

}
