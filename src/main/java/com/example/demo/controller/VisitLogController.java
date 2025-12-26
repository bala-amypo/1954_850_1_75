@RestController
@RequestMapping("/visit-logs")
@Tag(name = "VisitLog")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLog> create(@PathVariable Long visitorId,
                                           @RequestBody VisitLog log) {
        return ResponseEntity.ok(
                visitLogService.createVisitLog(visitorId, log)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getLog(id));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> listByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(visitLogService.getLogsByVisitor(visitorId));
    }
}
