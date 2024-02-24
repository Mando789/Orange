package com.example.demo.API.repository;

import com.example.demo.API.model.Dials;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DialsRepository extends CrudRepository<Dials, Integer> {

    Boolean existsByMsisdn(Long msisdn);

    @Query("SELECT ID FROM DIALS WHERE Msisdn = :msisdn")
    Integer getId(Long msisdn);

    Optional<Dials> findByMsisdn(Long msisdn);

}
