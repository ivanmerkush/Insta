package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.HashtagEntity;
import com.netcracker.ivanmerkush.backend.entity.PostHashtagEntity;

import java.util.List;

public interface HashtagService {
    List<HashtagEntity> getHashtagsBySearch(String searchWord);
    HashtagEntity saveHashtag(HashtagEntity hashtag);
    HashtagEntity getHashtagById(Integer id);
    HashtagEntity getHashtagByText(String text);
    void savePostHashtag(PostHashtagEntity postHashtag);
}
