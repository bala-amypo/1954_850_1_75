public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder encoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = repo;
        this.encoder = encoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse login(AuthRequest req) {
        return new AuthResponse("token");
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }
}
