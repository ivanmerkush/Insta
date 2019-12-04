package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.entity.SubEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubRepository extends CrudRepository<SubEntity, Integer> {

    List<SubEntity> getSubEntitiesByIdSubcriber(Integer id);
    Integer countAllByIdSubcriber(Integer id);
    Integer countAllByIdHost(Integer id);
}
