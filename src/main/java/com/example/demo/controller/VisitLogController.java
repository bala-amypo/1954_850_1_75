@RestController
@RequestMapping("/visit-logs")
@Tag(name = "VisitLog")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    public ResponseEntity<VisitLog> create(Long visitorId, VisitLog log) {
        return ResponseEntity.ok(
                visitLogService.createVisitLog(visitorId, log)
        );
    }

    public ResponseEntity<VisitLog> get(Long id) {
        return ResponseEntity.ok(visitLogService.getLog(id));
    }

    public ResponseEntity<List<VisitLog>> listByVisitor(Long visitorId) {
        return ResponseEntity.ok(visitLogService.getLogsByVisitor(visitorId));
    }
}
