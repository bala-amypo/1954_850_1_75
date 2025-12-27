package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;   // ✅ REQUIRED FIELD

    protected VisitLog() {}

    private VisitLog(Builder builder) {
        this.entryTime = builder.entryTime;
        this.exitTime = builder.exitTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    // =========================
    // ✅ BUILDER
    // =========================
    public static class Builder {

        private LocalDateTime entryTime;
        private LocalDateTime exitTime;  // ✅ REQUIRED

        public Builder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        // 🔥 THIS METHOD IS WHAT THE TEST EXPECTS
        public Builder exitTime(LocalDateTime exitTime) {
            this.exitTime = exitTime;
            return this;
        }

        public VisitLog build() {
            return new VisitLog(this);
        }
    }
}
