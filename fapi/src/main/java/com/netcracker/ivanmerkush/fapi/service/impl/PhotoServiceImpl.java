package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Photo;
import com.netcracker.ivanmerkush.fapi.service.PhotoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Photo getPhotoForPost(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Photo photo =  restTemplate.getForObject(backendServerUrl + "/api/photos/" + id, Photo.class);
        return photo;
    }
}
