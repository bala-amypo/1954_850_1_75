package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    // POST /api/visit-logs/{visitorId}
    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLog> createVisitLog(
            @PathVariable Long visitorId,
            @RequestBody VisitLog visitLog) {

        VisitLog createdLog = visitLogService.createVisitLog(visitorId, visitLog);
        return new ResponseEntity<>(createdLog, HttpStatus.CREATED);
    }

    // GET /api/visit-logs/visitor/{visitorId}
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> getLogsByVisitor(
            @PathVariable Long visitorId) {

        List<VisitLog> logs = visitLogService.getLogsByVisitor(visitorId);
        return ResponseEntity.ok(logs);
    }

    // GET /api/visit-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getVisitLog(
            @PathVariable Long id) {

        VisitLog log = visitLogService.getLog(id);
        return ResponseEntity.ok(log);
    }
}
