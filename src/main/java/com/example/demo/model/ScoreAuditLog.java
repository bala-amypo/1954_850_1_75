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

    public String getReason() {
        return reason;
    }

    public Integer getScoreChange() {
        return scoreChange;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void setAppliedRule(RiskRule appliedRule) {
        this.appliedRule = appliedRule;
    }
}
