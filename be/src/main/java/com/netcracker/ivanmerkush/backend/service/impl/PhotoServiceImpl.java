package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.PhotoEntity;
import com.netcracker.ivanmerkush.backend.repository.PhotoRepository;
import com.netcracker.ivanmerkush.backend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository repository;

    @Override
    public PhotoEntity getPhotoByIdPost(Integer id) {
        return repository.getPhotoEntityByIdPost(id);
    }

    @Override
    public PhotoEntity addPhoto(PhotoEntity photo) { return repository.save(photo);};
}
