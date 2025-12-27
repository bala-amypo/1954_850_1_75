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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public static Builder builder() { return new Builder(); }

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }

    public static class Builder {
        private final ScoreAuditLog s = new ScoreAuditLog();

        public Builder id(Long id) {
            s.setId(id);
            return this;
        }

        public Builder visitor(Visitor visitor) {
            s.visitor = visitor;
            return this;
        }

        public Builder appliedRule(RiskRule rule) {
            s.appliedRule = rule;
            return this;
        }

        public Builder scoreChange(Integer scoreChange) {
            s.scoreChange = scoreChange;
            return this;
        }

        public Builder reason(String reason) {
            s.reason = reason;
            return this;
        }

        public ScoreAuditLog build() {
            return s;
        }
    }
}
