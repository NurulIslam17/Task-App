package com.nurul.taskap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping
    public String loginForm(Model model)
    {
        return "auth/login";

    }

    @GetMapping("/register")
    public String register()
    {
        return "auth/register";
    }
}
