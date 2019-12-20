package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.HashtagEntity;
import com.netcracker.ivanmerkush.backend.entity.PostHashtagEntity;
import com.netcracker.ivanmerkush.backend.repository.HashtagRepository;
import com.netcracker.ivanmerkush.backend.repository.PostHashtagRepository;
import com.netcracker.ivanmerkush.backend.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtagServiceImpl implements HashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    @Autowired
    private PostHashtagRepository postHashtagRepository;

    @Override
    public List<HashtagEntity> getHashtagsBySearch(String request) {
        return hashtagRepository.getHashtagEntitiesByTextContaining(request);
    }

    @Override
    public HashtagEntity saveHashtag(HashtagEntity hashtag) {
        return hashtagRepository.save(hashtag);
    }

    @Override
    public HashtagEntity getHashtagById(Integer id) {
        return hashtagRepository.getHashtagEntityByIdHashtag(id);
    }

    @Override
    public HashtagEntity getHashtagByText(String text) {
        return hashtagRepository.getHashtagEntityByText(text);
    }

    @Override
    public void savePostHashtag(PostHashtagEntity postHashtag) {
        postHashtagRepository.save(postHashtag);
    }
}
