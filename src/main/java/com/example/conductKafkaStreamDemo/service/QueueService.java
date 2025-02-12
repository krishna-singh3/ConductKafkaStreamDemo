package com.example.conductKafkaStreamDemo.service;

import com.example.conductKafkaStreamDemo.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueService {

  @Autowired
  private MongoTemplate mongoTemplate;

  public Queue saveQueue(Queue queue) {
    return mongoTemplate.save(queue);
  }

  public List<Queue> getAllQueues() {
    return mongoTemplate.findAll(Queue.class);
  }
}