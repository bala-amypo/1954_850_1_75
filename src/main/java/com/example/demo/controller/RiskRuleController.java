package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;

@Tag(name = "Risk Rule Controller")
@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RiskRule> create(@RequestBody RiskRule rule) {
        return ResponseEntity.ok(
                riskRuleService.createRule(rule)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                riskRuleService.getRule(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(
                riskRuleService.getAllRules()
        );
    }
}
