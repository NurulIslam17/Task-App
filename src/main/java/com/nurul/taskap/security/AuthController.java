package com.nurul.taskap.security;

import com.nurul.taskap.dto.user.UserRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String login(Model model)
    {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        UserRequestDto userRequestDto = new UserRequestDto();
        model.addAttribute("userRegister", userRequestDto);
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userRegister")UserRequestDto userRequestDto)
    {
        authService.register(userRequestDto);
        return "redirect:/";
    }


}
