package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.PhotoEntity;
import com.netcracker.ivanmerkush.backend.repository.PhotoRepository;
import com.netcracker.ivanmerkush.backend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository repository;

    @Override
    public Optional<PhotoEntity> getPhotoByIdPost(Integer id) {
        return repository.getByIdPost(id);
    }
}
