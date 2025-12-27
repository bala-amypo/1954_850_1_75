package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Tag(name = "Visitor")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    public ResponseEntity<Visitor> create(Visitor v) {
        return ResponseEntity.ok(visitorService.createVisitor(v));
    }

    public ResponseEntity<Visitor> get(Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }

    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
}
