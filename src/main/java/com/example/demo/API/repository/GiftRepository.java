package com.example.demo.API.repository;

import com.example.demo.API.model.Gift;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GiftRepository extends CrudRepository<Gift, Integer> {

    Optional<Gift> findById(Integer Id);
}
