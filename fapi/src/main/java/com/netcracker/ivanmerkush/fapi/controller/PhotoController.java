package com.netcracker.ivanmerkush.fapi.controller;


import com.netcracker.ivanmerkush.fapi.models.Photo;
import com.netcracker.ivanmerkush.fapi.service.PhotoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Photo> getPhoto(@PathVariable String id) {
        return ResponseEntity.ok(photoService.getPhotoForPost(Integer.valueOf(id)));
    }

    @PostMapping()
    public ResponseEntity<Photo> addPhoto(@RequestBody Photo photo) {
        return ResponseEntity.ok(photoService.addPhoto(photo));
    }

    @PostMapping(value = "/uploadFile")
    public @ResponseBody
    void handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String uploadsDir = "D:/Photo/";

                String orgName = file.getOriginalFilename();
                String filePath = uploadsDir + orgName;
                File dest = new File(filePath);
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}