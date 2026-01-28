package com.nurul.taskap.controller;

import com.nurul.taskap.entity.Role;
import com.nurul.taskap.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role/list")
    public String allRoles(Model model)
    {
        List<Role> roles = roleService.allRoles();
        System.out.println(roles);
        model.addAttribute("roles",roles);
        return "role/list";
    }
}
