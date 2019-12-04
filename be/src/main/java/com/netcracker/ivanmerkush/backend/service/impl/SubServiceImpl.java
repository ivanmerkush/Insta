package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.SubEntity;
import com.netcracker.ivanmerkush.backend.repository.SubRepository;
import com.netcracker.ivanmerkush.backend.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubServiceImpl implements SubService {
    @Autowired
    private SubRepository subRepository;

    @Override
    public SubEntity addSub(SubEntity bond) {
        return subRepository.save(bond);
    }

    @Override
    public void deleteSub(Integer id) {
        subRepository.deleteById(id);
    }

    @Override
    public Integer countSubscribers(Integer id) {
        return subRepository.countAllByIdHost(id);
    }

    @Override
    public Integer countSubscriptions(Integer id) {
        return subRepository.countAllByIdSubcriber(id);
    }

    @Override
    public List<SubEntity> getSubcriptions(Integer id) {
        return subRepository.getSubEntitiesByIdSubcriber(id);
    }
}
