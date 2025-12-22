package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    List<VisitLog> findByVisitor(Visitor visitor);
}
