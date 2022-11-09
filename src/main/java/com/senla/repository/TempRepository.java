package com.senla.repository;

import com.senla.model.MomentFact;
import io.micrometer.core.annotation.Timed;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepository extends CrudRepository<MomentFact, UUID> {

    @Timed("gettingTempFromDB")
    List<MomentFact> findAll();
}
