package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.ComplaintEntity;
import com.netcracker.ivanmerkush.backend.entity.Reason;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ComplaintRepository extends CrudRepository<ComplaintEntity, Integer> {
    List<ComplaintEntity> getComplaintEntitiesByIdAccusedOrderByFillingDateDesc(Integer idAccused);
    List<ComplaintEntity> getComplaintEntitiesByReasonOrderByFillingDateDesc(Reason reason);
    Boolean existsComplaintEntityByIdProsecutorAndIdAccused(Integer idProsecutor, Integer idAccused);
    void deleteComplaintEntitiesByIdAccused(Integer idAccused);
    void deleteComplaintEntityByIdProsecutorAndIdAccused(Integer idProsecutor, Integer idAccused);
}
