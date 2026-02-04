package com.nurul.taskap.service;

import com.nurul.taskap.dto.user.UserDto;
import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Role;
import com.nurul.taskap.repository.RoleRepository;
import com.nurul.taskap.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getUserList(String role) {
        List<AppUser> users = userRepository.findByRoleName(role);
        return users
                .stream()
                .map(appUser -> modelMapper.map(appUser, UserDto.class))
                .toList();
    }

    public void addUser(UserRequestDto userRequestDto) {
        AppUser appUser =  userRepository.findByName(userRequestDto.getName());
        if(appUser != null)
        {
            throw new IllegalArgumentException("User already exist");
        }
        AppUser appUserData = new AppUser();
        appUserData.setName(userRequestDto.getName());
        appUserData.setUserName(userRequestDto.getUserName());
        appUserData.setPassword(passwordEncoder.encode("12345"));
        Role roles = roleRepository.findById(userRequestDto.getRole()).orElseThrow(()->new IllegalArgumentException("Role Not Found"));
        appUserData.setRoles(Arrays.asList(roles));
        appUserData.setDescription(userRequestDto.getDescription());
        userRepository.save(appUserData);
    }

    public UserDto userDetailById(Long id) {
        AppUser appUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("App User Not Found"));
        return modelMapper.map(appUser,UserDto.class);

    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto editUser(Long id) {
        Optional<AppUser> appUser = userRepository.findById(id);
        return modelMapper.map(appUser,UserDto.class);
    }


    public void updateUser(UserRequestDto userRequestDto, Long id) {

        System.out.println(userRequestDto);
        AppUser  userData = modelMapper.map(userRequestDto, AppUser.class);
        Role roles = roleRepository.findById(userRequestDto.getRole()).orElseThrow(()->new IllegalArgumentException("Role Not Found"));
        userData.setPassword(passwordEncoder.encode("12345"));
        userData.setRoles(Arrays.asList(roles));
        userData.setId(id);
        userRepository.save(userData);
    }

    public AppUser findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
    }
}
