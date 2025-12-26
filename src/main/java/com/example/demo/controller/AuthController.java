@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {

        Optional<User> existing = userService.findByEmail(req.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User u = User.builder()
                .email(req.getEmail())
                .password(req.getPassword())
                .roles(req.getRoles())
                .build();

        return ResponseEntity.ok(userService.save(u));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        return ResponseEntity.ok(userService.login(req));
    }
}
