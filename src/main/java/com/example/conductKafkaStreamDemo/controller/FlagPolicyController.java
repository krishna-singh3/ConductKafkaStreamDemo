package com.example.conductKafkaStreamDemo.controller;

import com.example.conductKafkaStreamDemo.model.FlagPolicy;
import com.example.conductKafkaStreamDemo.service.FlagPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flagPolicies")
public class FlagPolicyController {

  @Autowired
  private FlagPolicyService flagPolicyService;

  @PostMapping
  public FlagPolicy saveFlagPolicy(@RequestBody FlagPolicy flagPolicy) {
    return flagPolicyService.saveFlagPolicy(flagPolicy);
  }

  @GetMapping
  public List<FlagPolicy> getAllFlagPolicies() {
    return flagPolicyService.getAllFlagPolicies();
  }

  @PutMapping("/{id}")
  public FlagPolicy updateFlagPolicy(@PathVariable String id, @RequestBody FlagPolicy flagPolicy) {
    return flagPolicyService.updateFlagPolicy(id, flagPolicy);
  }
}