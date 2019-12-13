package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.PhotoEntity;

import java.util.Optional;

public interface PhotoService {
    PhotoEntity getPhotoByIdPost(Integer id);
    PhotoEntity addPhoto(PhotoEntity photo);
}
