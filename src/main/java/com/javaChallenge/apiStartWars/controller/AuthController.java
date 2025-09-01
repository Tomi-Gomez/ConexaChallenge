package com.javaChallenge.apiStartWars.controller;


import com.javaChallenge.apiStartWars.repository.UserRepository;
import com.javaChallenge.apiStartWars.request.AuthRequest;
import com.javaChallenge.apiStartWars.security.JwtUtil;
import com.javaChallenge.apiStartWars.security.user.AuthUser;
import com.javaChallenge.apiStartWars.security.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthUser request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String role = authentication.getAuthorities().iterator()
                .next().getAuthority().replace("ROLE_", "");
        String token = jwtUtil.generateToken(request.getUsername(), role);

        Map<String, String> response = new HashMap<>();
        response.put("username:" , request.getUsername());
        response.put("ROL:",role);
        response.put("token", token);

        return response;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody AuthRequest request) {
        AuthUser newUser = AuthUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(newUser);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado correctamente");
        return response;
    }
}
