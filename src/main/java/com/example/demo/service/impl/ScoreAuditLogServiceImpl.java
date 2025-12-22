package com.example.demo.service.impl;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.model.Visitor;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.ScoreAuditLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.ScoreAuditLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    private final ScoreAuditLogRepository scoreAuditLogRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository riskRuleRepository;

    public ScoreAuditLogServiceImpl(
            ScoreAuditLogRepository scoreAuditLogRepository,
            VisitorRepository visitorRepository,
            RiskRuleRepository riskRuleRepository) {
        this.scoreAuditLogRepository = scoreAuditLogRepository;
        this.visitorRepository = visitorRepository;
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() ->
                        new RuntimeException("Visitor not found with id " + visitorId));

        RiskRule rule = riskRuleRepository.findById(ruleId)
                .orElseThrow(() ->
                        new RuntimeException("RiskRule not found with id " + ruleId));

        if (log.getReason() == null || log.getReason().isEmpty()) {
            throw new IllegalArgumentException("reason required");
        }

        if (log.getScoreChange() < 0) {
            throw new IllegalArgumentException("scoreChange must be >= 0");
        }

        log.setVisitor(visitor);
        log.setAppliedRule(rule);

        return scoreAuditLogRepository.save(log);
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return scoreAuditLogRepository.findByVisitorId(visitorId);
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        return scoreAuditLogRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("ScoreAuditLog not found with id " + id));
    }
}
