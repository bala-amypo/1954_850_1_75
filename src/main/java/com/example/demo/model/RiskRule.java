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

    /* ---------- getters & setters ---------- */

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getScoreImpact() {
        return scoreImpact;
    }

    public void setScoreImpact(Integer scoreImpact) {
        this.scoreImpact = scoreImpact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /* ---------- lifecycle ---------- */

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    /* ---------- builder ---------- */

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final RiskRule r = new RiskRule();

        public Builder ruleName(String name) {
            r.setRuleName(name);
            return this;
        }

        public Builder ruleType(String type) {
            r.setRuleType(type);
            return this;
        }

        public Builder threshold(Integer threshold) {
            r.setThreshold(threshold);
            return this;
        }

        public Builder scoreImpact(Integer impact) {
            r.setScoreImpact(impact);
            return this;
        }

        public Builder createdAt(LocalDateTime time) {
            r.createdAt = time;
            return this;
        }

        public RiskRule build() {
            return r;
        }
    }
}
