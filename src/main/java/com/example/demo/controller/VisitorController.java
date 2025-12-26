@RestController
@RequestMapping("/visitors")
@Tag(name = "Visitor")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    public ResponseEntity<Visitor> create(@RequestBody Visitor v) {
        return ResponseEntity.ok(visitorService.createVisitor(v));
    }

    public ResponseEntity<Visitor> get(Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }

    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
}
