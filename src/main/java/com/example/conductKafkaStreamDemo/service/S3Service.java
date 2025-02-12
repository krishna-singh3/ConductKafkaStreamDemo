package com.example.conductKafkaStreamDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.core.ResponseInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class S3Service {

  @Value("${aws.s3.bucketName}")
  private String bucketName;


  @Autowired
  private S3Client s3Client;


  public String fetchJsonFromS3(String key) {
    GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(key).build();
    ResponseInputStream<GetObjectResponse> s3ObjectInputStream = s3Client.getObject(getObjectRequest);
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(s3ObjectInputStream, StandardCharsets.UTF_8));
    return reader.lines().collect(Collectors.joining("\n"));
  }
}