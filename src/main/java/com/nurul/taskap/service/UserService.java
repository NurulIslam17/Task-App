package com.nurul.taskap.service;

import com.nurul.taskap.dto.user.UserDto;
import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getUserList() {
        List<AppUser> users = userRepository.findAll();
        return users
                .stream()
                .map(appUser -> modelMapper.map(appUser, UserDto.class))
                .toList();
    }

    public void addUser(UserRequestDto userRequestDto) {
        AppUser appUser = (AppUser) userRepository.findByName(userRequestDto.getName()).orElse(null);
        if(appUser != null)
        {
            System.out.println("User already exist");
            throw new IllegalArgumentException("User already exist");
        }

        AppUser appUserData = new AppUser();
        appUserData.setName(userRequestDto.getName());
        appUserData.setUserName(userRequestDto.getUserName());
        appUserData.setDescription(userRequestDto.getDescription());
        userRepository.save(appUserData);
    }

    public UserDto userDetailById(Long id) {
        Optional<AppUser> appUser = userRepository.findById(id);
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
        AppUser  userData = modelMapper.map(userRequestDto, AppUser.class);
        userData.setId(id);
        userRepository.save(userData);
    }
}
