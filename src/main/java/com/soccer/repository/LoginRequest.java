package com.soccer.repository;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private String role;
}
