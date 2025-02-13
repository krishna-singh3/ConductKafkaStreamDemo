package com.example.conductKafkaStreamDemo.service;

import com.example.conductKafkaStreamDemo.model.FlagPolicy;
import com.example.conductKafkaStreamDemo.repository.FlagPolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlagPolicyService {

  @Autowired
  private FlagPolicyRepo flagPolicyRepo;

  public FlagPolicy saveFlagPolicy(FlagPolicy flagPolicy) {
    return flagPolicyRepo.save(flagPolicy);
  }

  public List<FlagPolicy> getAllFlagPolicies() {
    return flagPolicyRepo.findAll();
  }

  public FlagPolicy updateFlagPolicy(String id, FlagPolicy updatedFlagPolicy) {
    Optional<FlagPolicy> optionalFlagPolicy = flagPolicyRepo.findById(id);
    if (optionalFlagPolicy.isPresent()) {
      FlagPolicy existingFlagPolicy = optionalFlagPolicy.get();
      existingFlagPolicy.setDisabled(updatedFlagPolicy.isDisabled());
      existingFlagPolicy.setName(updatedFlagPolicy.getName());
      existingFlagPolicy.setSearchCriteriaFileName(updatedFlagPolicy.getSearchCriteriaFileName());
      existingFlagPolicy.setSearchCriteria(updatedFlagPolicy.getSearchCriteria());
      existingFlagPolicy.setSupervisionPolicyType(updatedFlagPolicy.getSupervisionPolicyType());
      return flagPolicyRepo.save(existingFlagPolicy);
    } else {
      throw new RuntimeException("FlagPolicy not found with id: " + id);
    }
  }
}