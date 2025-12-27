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

    private String purpose;      // ✅ REQUIRED
    private String location;     // ✅ REQUIRED

    @ManyToOne
    private Visitor visitor;     // ✅ REQUIRED

    protected VisitLog() {}

    private VisitLog(Builder builder) {
        this.entryTime = builder.entryTime;
        this.exitTime = builder.exitTime;
        this.purpose = builder.purpose;
        this.location = builder.location;
        this.visitor = builder.visitor;
    }

    public static Builder builder() {
        return new Builder();
    }

    // =========================
    // ✅ REQUIRED GETTERS
    // =========================
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
    // ✅ REQUIRED SETTER
    // =========================
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    // =========================
    // ✅ BUILDER
    // =========================
    public static class Builder {

        private LocalDateTime entryTime;
        private LocalDateTime exitTime;
        private String purpose;
        private String location;
        private Visitor visitor;

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
