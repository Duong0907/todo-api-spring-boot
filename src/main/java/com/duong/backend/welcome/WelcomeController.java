package com.duong.backend.welcome;

import com.duong.backend.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<Response> welcome(Principal principal) {
        return ResponseEntity.ok(new Response(
                "Welcome to my website",
                false,
                null
        ));
    }
}
