package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskRule;

public interface RiskRuleService {

    RiskRule createRule(RiskRule rule);

    List<RiskRule> getAllRules();

    RiskRule getRule(Long id);
}
