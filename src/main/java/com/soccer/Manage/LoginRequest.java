package com.soccer.Manage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private String role;
}
