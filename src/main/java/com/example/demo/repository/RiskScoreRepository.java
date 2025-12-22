package com.example.demo.repository;

import com.example.demo.model.RiskScore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {

    RiskScore findByVisitorId(Long visitorId);
}
