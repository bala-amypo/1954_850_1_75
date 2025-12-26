@RestController
@RequestMapping("/risk-rules")
@Tag(name = "RiskRule")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    @PostMapping
    public ResponseEntity<RiskRule> create(@RequestBody RiskRule rule) {
        return ResponseEntity.ok(riskRuleService.createRule(rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> get(@PathVariable Long id) {
        return ResponseEntity.ok(riskRuleService.getRule(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(riskRuleService.getAllRules());
    }
}
