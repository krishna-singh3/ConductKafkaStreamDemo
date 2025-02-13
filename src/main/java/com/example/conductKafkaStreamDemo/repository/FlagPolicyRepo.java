package com.example.conductKafkaStreamDemo.repository;

import com.example.conductKafkaStreamDemo.model.FlagPolicy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagPolicyRepo extends MongoRepository<FlagPolicy, String> {
}