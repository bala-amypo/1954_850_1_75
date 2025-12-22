package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }

    // POST /api/score-logs/{visitorId}/{ruleId} → create audit log
    @PostMapping("/{visitorId}/{ruleId}")
    public ScoreAuditLog createAuditLog(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log) {

        return scoreAuditLogService.logScoreChange(visitorId, ruleId, log);
    }

    // GET /api/score-logs/visitor/{visitorId} → list logs for visitor
    @GetMapping("/visitor/{visitorId}")
    public List<ScoreAuditLog> getLogsByVisitor(@PathVariable Long visitorId) {
        return scoreAuditLogService.getLogsByVisitor(visitorId);
    }

    // GET /api/score-logs/{id} → get log by id
    @GetMapping("/{id}")
    public ScoreAuditLog getLog(@PathVariable Long id) {
        return scoreAuditLogService.getLog(id);
    }
}
