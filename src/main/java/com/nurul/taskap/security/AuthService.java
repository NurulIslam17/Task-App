package com.nurul.taskap.security;

import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Role;
import com.nurul.taskap.repository.RoleRepository;
import com.nurul.taskap.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public void register(UserRequestDto userRequestDto) {

        System.out.println(userRequestDto);
        AppUser user  = new AppUser();
        user.setName(userRequestDto.getName());
        user.setUserName(userRequestDto.getUserName());
        user.setDescription(userRequestDto.getDescription());
        user.setPassword(userRequestDto.getPassword());
        Role roles = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(roles));
        userRepository.save(user);
    }
}
