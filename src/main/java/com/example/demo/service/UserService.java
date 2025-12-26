public interface UserService {
    AuthResponse login(AuthRequest request);
    Optional<User> findByEmail(String email);
    User save(User user);
}
