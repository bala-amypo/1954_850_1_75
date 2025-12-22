// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.Visitor;
// import com.example.demo.repository.VisitorRepository;
// import com.example.demo.service.VisitorService;

// import java.util.List;

// public class VisitorServiceImpl implements VisitorService {

//     private final VisitorRepository visitorRepository;

//     public VisitorServiceImpl(VisitorRepository visitorRepository) {
//         this.visitorRepository = visitorRepository;
//     }

//     @Override
//     public Visitor createVisitor(Visitor visitor) {
//         if (visitor.getPhone() == null || visitor.getPhone().isBlank()) {
//             throw new BadRequestException("phone required");
//         }
//         return visitorRepository.save(visitor);
//     }

//     @Override
//     public Visitor getVisitor(Long id) {
//         return visitorRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
//     }

//     @Override
//     public List<Visitor> getAllVisitors() {
//         return visitorRepository.findAll();
//     }
// }