package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Hashtag;

import java.util.List;

public interface HashtagService {
    List<Hashtag> getHashtagsBySearch(String searchWord);
    Hashtag saveHashtag(Hashtag hashtag);
    void savePostAndHashtag(Integer idPost, Integer idHashtag);
    Hashtag getHashtagByText(String text);
    Hashtag getHashtagById(Integer id);
}
