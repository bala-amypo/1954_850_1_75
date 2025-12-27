package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String ruleType;
    private Integer threshold;
    private Integer scoreImpact;
    private LocalDateTime createdAt;

    public RiskRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getRuleType() { return ruleType; }
    public void setRuleType(String ruleType) { this.ruleType = ruleType; }

    public Integer getThreshold() { return threshold; }
    public void setThreshold(Integer threshold) { this.threshold = threshold; }

    public Integer getScoreImpact() { return scoreImpact; }
    public void setScoreImpact(Integer scoreImpact) { this.scoreImpact = scoreImpact; }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final RiskRule r = new RiskRule();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder ruleName(String ruleName) {
            r.setRuleName(ruleName);
            return this;
        }

        public Builder ruleType(String ruleType) {
            r.setRuleType(ruleType);
            return this;
        }

        public Builder threshold(Integer threshold) {
            r.setThreshold(threshold);
            return this;
        }

        public Builder scoreImpact(Integer scoreImpact) {
            r.setScoreImpact(scoreImpact);
            return this;
        }

        public RiskRule build() {
            return r;
        }
    }
}
