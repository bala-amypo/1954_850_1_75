@RestController
@RequestMapping("/risk-rules")
@Tag(name = "RiskRule")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    public ResponseEntity<RiskRule> create(RiskRule rule) {
        return ResponseEntity.ok(riskRuleService.createRule(rule));
    }

    public ResponseEntity<RiskRule> get(Long id) {
        return ResponseEntity.ok(riskRuleService.getRule(id));
    }

    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(riskRuleService.getAllRules());
    }
}
