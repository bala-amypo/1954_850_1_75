package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @PrePersist
    public void validate() {
        if (scoreChange == null || scoreChange < 0) {
            throw new RuntimeException("scoreChange must be >= 0");
        }
        if (reason == null || reason.isBlank()) {
            throw new RuntimeException("reason required");
        }
        this.loggedAt = LocalDateTime.now();
    }
}