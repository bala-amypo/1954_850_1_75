package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String idProof;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "visitor")
    private List<VisitLog> visitLogs;

    @OneToOne(mappedBy = "visitor")
    private RiskScore riskScore;

    @OneToMany(mappedBy = "visitor")
    private List<ScoreAuditLog> scoreAuditLogs;

    public Visitor() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getIdProof() { return idProof; }
    public void setIdProof(String idProof) { this.idProof = idProof; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Visitor v = new Visitor();

        public Builder id(Long id) {
            v.setId(id);
            return this;
        }

        public Builder fullName(String fullName) {
            v.setFullName(fullName);
            return this;
        }

        public Builder email(String email) {
            v.setEmail(email);
            return this;
        }

        public Builder phone(String phone) {
            v.setPhone(phone);
            return this;
        }

        public Builder idProof(String idProof) {
            v.setIdProof(idProof);
            return this;
        }

        public Visitor build() {
            return v;
        }
    }
}
