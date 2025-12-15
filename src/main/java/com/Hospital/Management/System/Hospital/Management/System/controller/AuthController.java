package com.Hospital.Management.System.Hospital.Management.System.controller;

import com.Hospital.Management.System.Hospital.Management.System.dto.AuthRequest;
import com.Hospital.Management.System.Hospital.Management.System.dto.AuthResponse;
import com.Hospital.Management.System.Hospital.Management.System.model.User;
import com.Hospital.Management.System.Hospital.Management.System.repository.UserRepository;
import com.Hospital.Management.System.Hospital.Management.System.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            JwtUtil jwtUtil,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
public AuthResponse register(@RequestBody AuthRequest request) {

    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
        throw new RuntimeException("User already exists");
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole("PATIENT");

    userRepository.save(user);

    String token = jwtUtil.generateToken(
            user.getUsername(),
            user.getRole()
    );

    return new AuthResponse(
            token,
            user.getUsername(),
            user.getRole()
    );
}

    // ✅ LOGIN
   @PostMapping("/login")
public AuthResponse login(@RequestBody AuthRequest request) {

    User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new RuntimeException("Invalid username"));

    if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())
    ) {
        throw new RuntimeException("Invalid password");
    }

    String token = jwtUtil.generateToken(
            user.getUsername(),
            user.getRole()
    );

    return new AuthResponse(
            token,
            user.getUsername(),
            user.getRole()
    );
}
}
