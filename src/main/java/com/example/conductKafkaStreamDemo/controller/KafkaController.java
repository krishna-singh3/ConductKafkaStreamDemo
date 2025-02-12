package com.example.conductKafkaStreamDemo.controller;

import com.example.conductKafkaStreamDemo.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

  private final KafkaProducerService kafkaProducerService;

  public KafkaController(KafkaProducerService kafkaProducerService) {
    this.kafkaProducerService = kafkaProducerService;
  }

  @PostMapping("/publish")
  public String publishMessage(@RequestParam String topic, @RequestParam String message) {
    kafkaProducerService.sendMessage(topic, message);
    return "Message sent to topic: " + topic;
  }

  @GetMapping("/health")
  public String healthCheck() {
    return "App is running!";
  }
}

