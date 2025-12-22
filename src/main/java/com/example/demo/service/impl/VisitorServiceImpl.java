package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {

        if (visitor.getFullName() == null || visitor.getFullName().isEmpty()) {
            throw new IllegalArgumentException("fullName required");
        }

        if (visitor.getPhone() == null || visitor.getPhone().isEmpty()) {
            throw new IllegalArgumentException("phone required");
        }

        if (visitor.getIdProof() == null || visitor.getIdProof().isEmpty()) {
            throw new IllegalArgumentException("idProof required");
        }

        // createdAt is set in entity constructor
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found with id " + id));
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
