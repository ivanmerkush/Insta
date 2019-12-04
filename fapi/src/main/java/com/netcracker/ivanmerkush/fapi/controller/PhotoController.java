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

    @Autowired
    private HttpServletRequest request;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Photo> getPhoto(@PathVariable String id) {
        Long idPost = Long.valueOf(id);
        return ResponseEntity.ok(photoService.getPhotoForPost(idPost));
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
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

//    private static final Logger logger = Logger.getLogger(PhotoController.class.getName());
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
//        if (file == null) {
//            throw new RuntimeException("You must select the a file for uploading");
//        }
//        InputStream inputStream = file.getInputStream();
//        String originalName = file.getOriginalFilename();
//        String name = file.getName();
//        String contentType = file.getContentType();
//        long size = file.getSize();
//        logger.info("inputStream: " + inputStream);
//        logger.info("originalName: " + originalName);
//        logger.info("name: " + name);
//        logger.info("contentType: " + contentType);
//        logger.info("size: " + size);
//        // Do processing with uploaded file data in Service layer
//        return new ResponseEntity<String>(originalName, HttpStatus.OK);
//    }

