package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private RiskRule appliedRule;

    private Integer scoreChange;
    private String reason;
    private LocalDateTime loggedAt;

    public ScoreAuditLog() {}

    /* ---------- getters & setters ---------- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.scoreChange = scoreChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    /* ---------- lifecycle ---------- */

    @PrePersist
    public void prePersist() {
        if (loggedAt == null) {
            loggedAt = LocalDateTime.now();
        }
    }

    /* ---------- builder ---------- */

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ScoreAuditLog s = new ScoreAuditLog();

        public Builder id(Long id) {
            s.setId(id);
            return this;
        }

        public Builder visitor(Visitor visitor) {
            s.setVisitor(visitor);
            return this;
        }

        public Builder appliedRule(RiskRule rule) {
            s.setAppliedRule(rule);
            return this;
        }

        public Builder scoreChange(Integer scoreChange) {
            s.setScoreChange(scoreChange);
            return this;
        }

        public Builder reason(String reason) {
            s.setReason(reason);
            return this;
        }

        public Builder loggedAt(LocalDateTime time) {
            s.loggedAt = time;
            return this;
        }

        public ScoreAuditLog build() {
            return s;
        }
    }
}
