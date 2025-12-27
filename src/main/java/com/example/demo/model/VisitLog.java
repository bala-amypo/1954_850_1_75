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
    private LocalDateTime exitTime;

    public VisitLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Visitor getVisitor() { return visitor; }
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getEntryTime() { return entryTime; }
    public void setEntryTime(LocalDateTime entryTime) { this.entryTime = entryTime; }

    @PrePersist
    public void prePersist() {
        if (entryTime == null) entryTime = LocalDateTime.now();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final VisitLog v = new VisitLog();

        public Builder id(Long id) {
            v.setId(id);
            return this;
        }

        public Builder visitor(Visitor visitor) {
            v.setVisitor(visitor);
            return this;
        }

        public Builder purpose(String purpose) {
            v.setPurpose(purpose);
            return this;
        }

        public Builder location(String location) {
            v.setLocation(location);
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime) {
            v.setEntryTime(entryTime);
            return this;
        }

        public VisitLog build() {
            return v;
        }
    }
}
