package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RiskRule;

public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {

    boolean existsByRuleName(String ruleName);
}
