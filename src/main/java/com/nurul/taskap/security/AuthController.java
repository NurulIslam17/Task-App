package com.nurul.taskap.security;

import org.springframework.stereotype.Controller;

@Controller
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }
}
