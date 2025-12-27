package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleName;
    private String ruleType;
    private Integer scoreImpact;
    private Integer threshold;
}
