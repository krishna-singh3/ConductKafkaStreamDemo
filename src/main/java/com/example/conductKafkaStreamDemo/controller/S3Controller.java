package com.example.conductKafkaStreamDemo.controller;

import com.example.conductKafkaStreamDemo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S3Controller {

  @Autowired
  private S3Service s3Service;

  @GetMapping("/fetch-json")
  public String fetchJson(@RequestParam String key) {
    return s3Service.fetchJsonFromS3(key);
  }
}