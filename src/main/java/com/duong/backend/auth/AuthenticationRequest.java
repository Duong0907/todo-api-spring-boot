package com.duong.backend.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthenticationRequest {
    private String email;
    private String password;
}
