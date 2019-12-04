package com.netcracker.ivanmerkush.fapi.service;


import com.netcracker.ivanmerkush.fapi.models.Sub;

import java.util.List;

public interface SubService {
    Sub saveSub(Sub bond);
    void deleteSub(Long id);
    Integer countSubscribers(Long id);
    Integer countSubscriptions(Long id);
    List<Sub> getSubscriptions(Long id);
}
