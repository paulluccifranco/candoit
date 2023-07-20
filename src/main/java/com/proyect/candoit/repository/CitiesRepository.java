package com.proyect.candoit.repository;

import com.proyect.candoit.model.Cities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends MongoRepository<Cities, String> {

    Cities findFirstByOrderByDateDesc();
}
