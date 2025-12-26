@RestController
@RequestMapping("/audit-logs")
@Tag(name = "ScoreAuditLog")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> create(@PathVariable Long visitorId,
                                                @PathVariable Long ruleId,
                                                @RequestBody ScoreAuditLog log) {
        return ResponseEntity.ok(
                scoreAuditLogService.logScoreChange(visitorId, ruleId, log)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(scoreAuditLogService.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(scoreAuditLogService.getLogsByVisitor(visitorId));
    }
}
