package com.netcracker.ivanmerkush.fapi.service;


import com.netcracker.ivanmerkush.fapi.models.Sub;

import java.util.List;

public interface SubService {
    Sub saveSub(Sub bond);
    void deleteSub(Integer id);
    Integer countSubscribers(Integer id);
    Integer countSubscriptions(Integer id);
    List<Sub> getSubscriptions(Integer id);
    Boolean isBondExists(Integer idHost, Integer idSub);
    Sub getBond(Integer idHost, Integer idSub);
}
