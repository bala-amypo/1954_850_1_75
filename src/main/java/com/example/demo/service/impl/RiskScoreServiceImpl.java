// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.RiskRule;
// import com.example.demo.model.RiskScore;
// import com.example.demo.model.Visitor;
// import com.example.demo.repository.RiskRuleRepository;
// import com.example.demo.repository.RiskScoreRepository;
// import com.example.demo.repository.VisitorRepository;
// import com.example.demo.service.RiskScoreService;
// import com.example.demo.util.RiskLevelUtils;

// import java.util.List;

// public class RiskScoreServiceImpl implements RiskScoreService {

//     private final VisitorRepository visitorRepository;
//     private final RiskRuleRepository riskRuleRepository;
//     private final RiskScoreRepository riskScoreRepository;

//     public RiskScoreServiceImpl(
//             VisitorRepository visitorRepository,
//             RiskRuleRepository riskRuleRepository,
//             RiskScoreRepository riskScoreRepository) {
//         this.visitorRepository = visitorRepository;
//         this.riskRuleRepository = riskRuleRepository;
//         this.riskScoreRepository = riskScoreRepository;
//     }

//     @Override
//     public RiskScore evaluateVisitor(Long visitorId) {
//         Visitor visitor = visitorRepository.findById(visitorId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

//         List<RiskRule> rules = riskRuleRepository.findAll();
//         int totalScore = 0;

//         for (RiskRule rule : rules) {
//             totalScore += rule.getScoreImpact();
//         }

//         if (totalScore < 0) {
//             totalScore = 0;
//         }

//         String level = RiskLevelUtils.determineRiskLevel(totalScore);

//         RiskScore score = RiskScore.builder()
//                 .visitor(visitor)
//                 .totalScore(totalScore)
//                 .riskLevel(level)
//                 .build();

//         return riskScoreRepository.save(score);
//     }

//     @Override
//     public RiskScore getScoreForVisitor(Long visitorId) {
//         return riskScoreRepository.findByVisitorId(visitorId)
//                 .orElseThrow(() -> new ResourceNotFoundException("RiskScore not found"));
//     }

//     @Override
//     public List<RiskScore> getAllScores() {
//         return riskScoreRepository.findAll();
//     }
// }