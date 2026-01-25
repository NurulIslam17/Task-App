package com.nurul.taskap.security;

import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Role;
import com.nurul.taskap.repository.RoleRepository;
import com.nurul.taskap.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRequestDto userRequestDto) {

        AppUser user = new AppUser();
        user.setName(userRequestDto.getName());
        user.setUserName(userRequestDto.getUserName());
        user.setDescription(userRequestDto.getDescription());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        Role roles = roleRepository.findByName("ROLE_USER");
        if(roles == null)
        {
            roles = new Role();
            roles.setName("ROLE_USER");
            roles = roleRepository.save(roles);
        }
        user.setRoles(Arrays.asList(roles));
        userRepository.save(user);
    }
}
