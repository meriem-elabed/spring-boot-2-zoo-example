package com.zoo.repository;

import com.zoo.model.Dragon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DragonRepository extends MongoRepository<Dragon, String> {
}
