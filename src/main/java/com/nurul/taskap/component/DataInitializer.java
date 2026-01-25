package com.nurul.taskap.component;

import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Role;
import com.nurul.taskap.repository.RoleRepository;
import com.nurul.taskap.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findByName("admin@app.com") == null)
        {
            AppUser user = new AppUser();
            user.setUserName("Admin");
            user.setName("admin@app.com");
            user.setPassword(passwordEncoder.encode("12345"));
            user.setDescription("Admin description");
            Role roles = roleRepository.findByName("ROLE_ADMIN");
            if(roles == null)
            {
                roles = new Role();
                roles.setName("ROLE_ADMIN");
                roles = roleRepository.save(roles);
            }
            user.setRoles(Arrays.asList(roles));
            userRepository.save(user);
        }

    }
}
