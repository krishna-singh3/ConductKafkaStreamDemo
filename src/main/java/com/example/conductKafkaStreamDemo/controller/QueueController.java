package com.example.conductKafkaStreamDemo.controller;

import com.example.conductKafkaStreamDemo.model.Queue;
import com.example.conductKafkaStreamDemo.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queues")
public class QueueController {

  @Autowired
  private QueueService queueService;

  @PostMapping
  public Queue saveQueue(@RequestBody Queue queue) {
    return queueService.saveQueue(queue);
  }

  @GetMapping
  public List<Queue> getAllQueues() {
    return queueService.getAllQueues();
  }
}