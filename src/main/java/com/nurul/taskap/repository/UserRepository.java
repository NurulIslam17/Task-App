package com.nurul.taskap.repository;

import com.nurul.taskap.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByName(String username);

    @Query("SELECT DISTINCT u FROM AppUser u JOIN u.roles r WHERE r.name = :roleName")
    List<AppUser> findByRoleName(@Param("roleName") String roleName);

    AppUser findByUserName(String userName);
}
