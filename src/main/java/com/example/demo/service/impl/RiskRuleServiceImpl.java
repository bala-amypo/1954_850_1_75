package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository riskRuleRepository;

    public RiskRuleServiceImpl(RiskRuleRepository riskRuleRepository) {
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public RiskRule createRule(RiskRule rule) {

        if (riskRuleRepository.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule name must be unique");
        }

        return riskRuleRepository.save(rule);
    }

    @Override
    public List<RiskRule> getAllRules() {
        return riskRuleRepository.findAll();
    }

    @Override
    public RiskRule getRule(Long id) {
        return riskRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskRule not found"));
    }
}
