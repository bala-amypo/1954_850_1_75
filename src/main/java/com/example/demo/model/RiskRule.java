package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "risk_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "rule_name")
    }
)
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name", nullable = false)
    private String ruleName;

    @Column(nullable = false)
    private String ruleType;
    // AFTER_HOURS / FREQUENT_VISITS / BLACKLIST / KEYWORD / CUSTOM

    @Column(nullable = false)
    private Integer threshold;

    @Column(nullable = false)
    private Integer scoreImpact;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public RiskRule() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();

        if (threshold == null || threshold < 0) {
            throw new IllegalArgumentException("threshold must be >= 0");
        }

        if (scoreImpact == null || scoreImpact < 0) {
            throw new IllegalArgumentException("scoreImpact must be >= 0");
        }
    }

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
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold must be >= 0");
        }
        this.threshold = threshold;
    }

    public Integer getScoreImpact() {
        return scoreImpact;
    }

    public void setScoreImpact(Integer scoreImpact) {
        if (scoreImpact < 0) {
            throw new IllegalArgumentException("scoreImpact must be >= 0");
        }
        this.scoreImpact = scoreImpact;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
