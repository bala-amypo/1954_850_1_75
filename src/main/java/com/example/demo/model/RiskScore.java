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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getTotalScore() { return totalScore; }
    public void setTotalScore(Integer totalScore) { this.totalScore = totalScore; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final RiskScore r = new RiskScore();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder visitor(Visitor visitor) {
            r.visitor = visitor;
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
            r.riskRule = rule;
            return this;
        }

        public RiskScore build() {
            return r;
        }
    }
}
