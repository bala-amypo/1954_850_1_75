package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Visitor visitor;

    private Integer totalScore;
    private String riskLevel;

    @OneToOne
    private RiskRule riskRule;

    private LocalDateTime evaluatedAt;

    public RiskScore() {}

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public void setRiskRule(RiskRule riskRule) {
        this.riskRule = riskRule;
    }
}
