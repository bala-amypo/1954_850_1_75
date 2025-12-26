@RestController
@RequestMapping("/audit-logs")
@Tag(name = "ScoreAuditLog")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }

    public ResponseEntity<ScoreAuditLog> create(Long visitorId, Long ruleId, ScoreAuditLog log) {
        return ResponseEntity.ok(
                scoreAuditLogService.logScoreChange(visitorId, ruleId, log)
        );
    }

    public ResponseEntity<ScoreAuditLog> get(Long id) {
        return ResponseEntity.ok(scoreAuditLogService.getLog(id));
    }

    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(Long visitorId) {
        return ResponseEntity.ok(scoreAuditLogService.getLogsByVisitor(visitorId));
    }
}
