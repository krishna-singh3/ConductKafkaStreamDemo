package com.example.conductKafkaStreamDemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "flagPolicies")
@Getter
@Setter
public class FlagPolicy {

  @Id
  private String id;
  private boolean disabled;
  private String name;
  private String searchCriteriaFileName;
  private SearchCriteria searchCriteria;
  private String supervisionPolicyType;

  @Setter
  @Getter
  public static class SearchCriteria {
    private Map<String, WordsAndPhrases> wordsAndPhrases;
  }

  @Setter
  @Getter
  public static class WordsAndPhrases {
    private Terms mustAny;
    private Terms mustNot;
  }

  @Setter
  @Getter
  public static class Terms {
    private List<String> terms;
  }
}