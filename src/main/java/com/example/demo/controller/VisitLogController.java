package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Visit Log Controller")
@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLog> create(@PathVariable Long visitorId, @RequestBody VisitLog log) {
        return ResponseEntity.ok(visitLogService.createVisitLog(visitorId, log));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> listByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(visitLogService.getLogsByVisitor(visitorId));
    }
}
