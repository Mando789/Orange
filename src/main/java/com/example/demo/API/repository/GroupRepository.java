package com.example.demo.API.repository;

import com.example.demo.API.model.Groups;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Groups, Integer> {
}
