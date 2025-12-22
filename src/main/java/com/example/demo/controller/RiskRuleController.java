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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ruleName"))
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String ruleType; 
    // AFTER_HOURS / FREQUENT_VISITS / BLACKLIST / KEYWORD / CUSTOM

    private Integer threshold;

    private Integer scoreImpact;

    private LocalDateTime createdAt;

    @PrePersist
    public void validate() {
        if (threshold == null || threshold < 0) {
            throw new RuntimeException("threshold must be >= 0");
        }
        if (scoreImpact == null || scoreImpact < 0) {
            throw new RuntimeException("scoreImpact must be >= 0");
        }
        this.createdAt = LocalDateTime.now();
    }
}