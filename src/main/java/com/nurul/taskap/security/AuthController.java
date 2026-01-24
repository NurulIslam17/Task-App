package com.nurul.taskap.security;

import com.nurul.taskap.dto.user.LoginDto;
import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {

    private final AuthService authService;
    private  final UserRepository userRepository;


    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String login()
    {
        return "auth/login";
    }
    @PostMapping("/authenticated")
    public String authenticatedUser()
    {
        return "";
    }


    @GetMapping("/register")
    public String register(Model model)
    {
        UserRequestDto userRequestDto = new UserRequestDto();
        model.addAttribute("userRegister", userRequestDto);
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegister")UserRequestDto userRequestDto, BindingResult result, Model model)
    {
        AppUser existingUser = userRepository.findByName(userRequestDto.getName());
        if(existingUser != null)
        {
            model.addAttribute("userRegister",userRequestDto);
            return "auth/register";
        }
        authService.register(userRequestDto);
        return "redirect:/register?success";
    }

}
