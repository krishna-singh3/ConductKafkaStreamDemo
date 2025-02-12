package com.example.conductKafkaStreamDemo.repository;

import com.example.conductKafkaStreamDemo.model.Queue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface queueRepo extends MongoRepository<Queue, String> {
  Queue findByName(String name);
}