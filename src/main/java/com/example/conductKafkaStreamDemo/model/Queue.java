package com.example.conductKafkaStreamDemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "queues")
@Getter
@Setter
public class Queue {

  @Id
  private String id;
  private String name;
  private String description;
  private boolean disabled;
  private boolean invalidQueue;
  private boolean deleted;
  private long createdTime;
  private User createdBy;
  private long updatedTime;
  private User updatedBy;
  private int version;
  private long queueNextRunDateTime;
  private String createdTimeAsString;
  private String updatedTimeAsString;
  private long queueLastRunTime;
  private String queueLastRunTimeStr;


  @Setter
  @Getter
  public static class User {
    private String id;
  }
}