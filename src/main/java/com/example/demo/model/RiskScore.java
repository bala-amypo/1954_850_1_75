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

    /* ---------- getters & setters ---------- */

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public RiskRule getRiskRule() {
        return riskRule;
    }

    public void setRiskRule(RiskRule riskRule) {
        this.riskRule = riskRule;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }

    /* ---------- builder ---------- */

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final RiskScore r = new RiskScore();

        public Builder visitor(Visitor visitor) {
            r.setVisitor(visitor);
            return this;
        }

        public Builder totalScore(Integer totalScore) {
            r.setTotalScore(totalScore);
            return this;
        }

        public Builder riskLevel(String riskLevel) {
            r.setRiskLevel(riskLevel);
            return this;
        }

        public Builder riskRule(RiskRule rule) {
            r.setRiskRule(rule);
            return this;
        }

        public Builder evaluatedAt(LocalDateTime time) {
            r.setEvaluatedAt(time);
            return this;
        }

        public RiskScore build() {
            return r;
        }
    }
}
