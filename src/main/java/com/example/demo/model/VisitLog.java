package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    private String purpose;
    private String location;
    private LocalDateTime entryTime;

    public VisitLog() {}

    public String getPurpose() {
        return purpose;
    }

    public String getLocation() {
        return location;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
