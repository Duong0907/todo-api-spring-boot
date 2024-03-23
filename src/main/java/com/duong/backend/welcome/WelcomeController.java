package com.duong.backend.welcome;

import com.duong.backend.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<Response> welcome() {
        Response res = Response.builder().message("Welcome to my website").error(false).build();
        return ResponseEntity.ok(res);
    }
}
