package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Photo;

public interface PhotoService {
    Photo getPhotoForPost(Long id);
}
