// package com.example.demo.service.impl;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import java.util.Set;

// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtTokenProvider jwtTokenProvider;

//     public UserServiceImpl(
//             UserRepository userRepository,
//             PasswordEncoder passwordEncoder,
//             JwtTokenProvider jwtTokenProvider) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @Override
//     public User register(RegisterRequest request) {
//         userRepository.findByEmail(request.getEmail())
//                 .ifPresent(u -> {
//                     throw new BadRequestException("Email already exists");
//                 });

//         User user = User.builder()
//                 .email(request.getEmail())
//                 .password(passwordEncoder.encode(request.getPassword()))
//                 .role(Set.of("ROLE_USER"))
//                 .build();

//         return userRepository.save(user);
//     }

//     @Override
//     public AuthResponse login(AuthRequest request) {
//         User user = userRepository.findByEmail(request.getEmail())
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             throw new BadRequestException("Invalid credentials");
//         }

//         String token = jwtTokenProvider.generateToken(
//                 user.getEmail(), user.getRole());

//         return new AuthResponse(token, user.getEmail(), user.getRole());
//     }

//     @Override
//     public User getByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }
// }