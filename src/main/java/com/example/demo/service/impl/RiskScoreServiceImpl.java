package com.example.demo.service.impl;

import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(
            RiskScoreRepository riskScoreRepository,
            VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() ->
                        new RuntimeException("Visitor not found with id " + visitorId));

        // Example totalScore logic (can be changed later)
        int totalScore = 10;

        if (totalScore < 0) {
            throw new IllegalArgumentException("totalScore must be >= 0");
        }

        String riskLevel;
        if (totalScore < 20) {
            riskLevel = "LOW";
        } else if (totalScore < 50) {
            riskLevel = "MEDIUM";
        } else if (totalScore < 80) {
            riskLevel = "HIGH";
        } else {
            riskLevel = "CRITICAL";
        }

        RiskScore riskScore = new RiskScore();
        riskScore.setVisitor(visitor);
        riskScore.setTotalScore(totalScore);
        riskScore.setRiskLevel(riskLevel);

        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId);
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
