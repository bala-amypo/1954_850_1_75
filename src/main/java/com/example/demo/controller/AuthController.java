@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {

        if (userService.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.status(400).build();
        }

        User user = User.builder()
                .email(req.getEmail())
                .password(req.getPassword())
                .roles(req.getRoles())
                .build();

        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        return ResponseEntity.ok(userService.login(req));
    }
}
