package com.nurul.taskap.service;

import com.nurul.taskap.entity.Role;
import com.nurul.taskap.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> allRoles() {
      return roleRepository.findAll();
    }
}
