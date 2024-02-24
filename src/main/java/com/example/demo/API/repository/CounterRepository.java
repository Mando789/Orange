package com.example.demo.API.repository;

import com.example.demo.API.model.Counter;
import com.example.demo.API.model.Dials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CounterRepository extends CrudRepository<Counter, Integer> {

    Optional<Counter> findByMsisdn(Long msisdn);
}
