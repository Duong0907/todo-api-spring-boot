package com.duong.backend.auth;

import com.duong.backend.responses.Response;
import com.duong.backend.users.Role;
import com.duong.backend.users.User;
import com.duong.backend.users.UserRepository;
import com.duong.backend.configs.JwtService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Response register(@NotNull RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);
        return new Response(
                "Register successfully",
                false,
                null
        );
    }

    public Response login(@NotNull AuthenticationRequest request) {
        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return new Response(
                "Login successfully",
                false,
                new HashMap<>() {{
                    put("access_token", jwtToken);
                }}
        );
    }
}
