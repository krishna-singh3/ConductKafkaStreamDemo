package com.example.conductKafkaStreamDemo.service;

import com.example.conductKafkaStreamDemo.model.Queue;
import com.example.conductKafkaStreamDemo.repository.QueueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QueueService {

  @Autowired
  private QueueRepo queueRepo;

  public Queue saveQueue(Queue queue) {
    if (queue == null) {
      throw new IllegalArgumentException("Queue cannot be null");
    }

    return Optional.ofNullable(queue.getId())
        .map(id -> updateQueue(id, queue))
        .orElseGet(() -> queueRepo.save(queue));
  }

  public Queue updateQueue(String id, Queue updatedQueue) {
    if (id == null || updatedQueue == null) {
      throw new IllegalArgumentException("ID and Queue cannot be null");
    }

    Queue existingQueue = queueRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Queue not found with id: " + id));

    existingQueue.setName(updatedQueue.getName());
    existingQueue.setDescription(updatedQueue.getDescription());
    existingQueue.setSupervisedParticipants(updatedQueue.getSupervisedParticipants());
    existingQueue.setQueryMetadata(updatedQueue.getQueryMetadata());
    existingQueue.setDisabled(updatedQueue.isDisabled());

    return queueRepo.save(existingQueue);
  }


  public List<Queue> getAllQueues() {
    return queueRepo.findAll();
  }


}