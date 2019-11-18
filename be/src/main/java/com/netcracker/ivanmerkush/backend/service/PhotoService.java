package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.PhotoEntity;

import java.util.Optional;

public interface PhotoService {

    Optional<PhotoEntity> getPhotoByIdPost(Integer id);

}
