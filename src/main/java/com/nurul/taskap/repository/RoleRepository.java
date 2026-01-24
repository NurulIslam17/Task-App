package com.nurul.taskap.repository;

import com.nurul.taskap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String user);
}
