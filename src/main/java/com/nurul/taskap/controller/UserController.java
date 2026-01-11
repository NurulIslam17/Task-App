package com.nurul.taskap.controller;

import com.nurul.taskap.dto.user.UserDto;
import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/list")
    public String getUserList(Model model) {
        List<UserDto> userDtos = userService.getUserList();
        model.addAttribute("users",userDtos);
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUserForm(Model model)
    {
        UserRequestDto user = new UserRequestDto();
        model.addAttribute("user",user);
        return "user/add";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute("user") UserRequestDto userRequestDto)
    {
        userService.addUser(userRequestDto);
        return "redirect:/user/list?success";
    }

    @GetMapping("/user/details/{id}")
    public String userDetailById(@PathVariable Long id, Model model)
    {
        UserDto userDto = userService.userDetailById(id);
        model.addAttribute("user", userDto);
        return "user/details";
    }


}
