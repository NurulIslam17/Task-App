package com.nurul.taskap.repository;

import com.nurul.taskap.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByName(String username);
}
