@RestController
@RequestMapping("/visitors")
@Tag(name = "Visitor")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<Visitor> create(@RequestBody Visitor v) {
        return ResponseEntity.ok(visitorService.createVisitor(v));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> get(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
}
