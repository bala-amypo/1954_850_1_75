package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    // POST /api/risk-scores/evaluate/{visitorId} → evaluate visitor
    @PostMapping("/evaluate/{visitorId}")
    public RiskScore evaluateVisitor(@PathVariable Long visitorId) {
        return riskScoreService.evaluateVisitor(visitorId);
    }

    // GET /api/risk-scores/{visitorId} → get score for visitor
    @GetMapping("/{visitorId}")
    public RiskScore getScoreForVisitor(@PathVariable Long visitorId) {
        return riskScoreService.getScoreForVisitor(visitorId);
    }

    // GET /api/risk-scores → list all scores
    @GetMapping
    public List<RiskScore> getAllScores() {
        return riskScoreService.getAllScores();
    }
}
