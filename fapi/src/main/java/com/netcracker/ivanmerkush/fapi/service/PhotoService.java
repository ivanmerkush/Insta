package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Photo;

public interface PhotoService {
    Photo getPhotoForPost(Integer id);
    Photo addPhoto(Photo photo);
    void deletePhoto(Integer id);
}
