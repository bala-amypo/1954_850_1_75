package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    // POST /api/risk-rules
    @PostMapping
    public ResponseEntity<RiskRule> createRule(
            @RequestBody RiskRule rule) {

        RiskRule createdRule = riskRuleService.createRule(rule);
        return new ResponseEntity<>(createdRule, HttpStatus.CREATED);
    }

    // GET /api/risk-rules
    @GetMapping
    public ResponseEntity<List<RiskRule>> getAllRules() {

        List<RiskRule> rules = riskRuleService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    // GET /api/risk-rules/{id}
    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> getRule(
            @PathVariable Long id) {

        RiskRule rule = riskRuleService.getRule(id);
        return ResponseEntity.ok(rule);
    }
}
