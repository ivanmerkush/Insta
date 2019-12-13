package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.SubEntity;

import java.util.List;

public interface SubService {
    SubEntity addSub(SubEntity bond);
    void deleteSub(Integer id);
    Integer countSubscribers(Integer id);
    Integer countSubscriptions(Integer id);
    List<SubEntity> getSubcriptions(Integer id);
    Boolean isBondExists(Integer idHost, Integer idSubscriber);
    SubEntity getBond(Integer idHost, Integer idSubscriber);
}
