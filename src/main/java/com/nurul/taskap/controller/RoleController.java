package com.nurul.taskap.controller;

import com.nurul.taskap.entity.Role;
import com.nurul.taskap.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        Role roleData = new Role();

        model.addAttribute("roleData",roleData);
        model.addAttribute("roles",roles);
        return "role/list";
    }

    @PostMapping("/role/list")
    public String saveRole(@ModelAttribute("roleData") Role role)
    {
        roleService.addRole(role);
        return "redirect:/role/list";
    }
}
