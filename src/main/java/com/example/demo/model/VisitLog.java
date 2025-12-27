package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private String purpose;
    private String location;

    @ManyToOne
    private Visitor visitor;

    // ✅ MUST be PUBLIC (tests use new VisitLog())
    public VisitLog() {}

    private VisitLog(Builder builder) {
        this.id = builder.id;
        this.entryTime = builder.entryTime;
        this.exitTime = builder.exitTime;
        this.purpose = builder.purpose;
        this.location = builder.location;
        this.visitor = builder.visitor;
    }

    // =========================
    // ✅ JPA LIFECYCLE (tests call it directly)
    // =========================
    @PrePersist
    public void prePersist() {
        if (entryTime == null) {
            entryTime = LocalDateTime.now();
        }
    }

    // =========================
    // ✅ GETTERS
    // =========================
    public Long getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getLocation() {
        return location;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    // =========================
    // ✅ SETTERS (tests require these)
    // =========================
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    // =========================
    // ✅ BUILDER
    // =========================
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private LocalDateTime entryTime;
        private LocalDateTime exitTime;
        private String purpose;
        private String location;
        private Visitor visitor;

        // 🔥 REQUIRED BY TESTS
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder exitTime(LocalDateTime exitTime) {
            this.exitTime = exitTime;
            return this;
        }

        public Builder purpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder visitor(Visitor visitor) {
            this.visitor = visitor;
            return this;
        }

        public VisitLog build() {
            return new VisitLog(this);
        }
    }
}
