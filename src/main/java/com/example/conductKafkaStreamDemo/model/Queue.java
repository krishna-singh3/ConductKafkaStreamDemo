package com.example.conductKafkaStreamDemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "queues")
@Getter
@Setter
public class Queue {

  @Id
  private String id;
  private String name;
  private String description;
  private boolean disabled;
  private List<SupervisedParticipant> supervisedParticipants;
  private QueryMetadata queryMetadata;

  @Setter
  @Getter
  public static class SupervisedParticipant {
    private Group group;
  }

  @Setter
  @Getter
  public static class Group {
    private String id;
    private String name;
  }

  @Setter
  @Getter
  public static class QueryMetadata {
    private int maxItemsPerQuery;
    private List<Query> queries;
  }

  @Setter
  @Getter
  public static class Query {
    private QueryDetails query;
    private boolean enabled;
    private int docCount;
  }

  @Setter
  @Getter
  public static class QueryDetails {
    private String id;
    private String name;
    private String policyType;
  }
}