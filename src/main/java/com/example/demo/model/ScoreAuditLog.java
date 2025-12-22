package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
@Table(name = "score_audit_logs")
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "risk_rule_id", nullable = false)
    private RiskRule appliedRule;

    @Column(nullable = false)
    private Integer scoreChange;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public RiskRule getAppliedRule() {
        return appliedRule;
    }

    public void setAppliedRule(RiskRule appliedRule) {
        this.appliedRule = appliedRule;
    }

    public Integer getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(Integer scoreChange) {
        if (scoreChange < 0) {
            throw new IllegalArgumentException("scoreChange must be >= 0");
        }
        this.scoreChange = scoreChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if (reason == null || reason.isEmpty()) {
            throw new IllegalArgumentException("reason required");
        }
        this.reason = reason;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
