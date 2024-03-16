package com.duong.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<List<String>> welcome(Principal principal) {
        return ResponseEntity.ok(Arrays.asList(
                "Hello",
                principal.getName()
        ));
    }
}
