package com.nurul.taskap.service;

import com.nurul.taskap.dto.user.UserDto;
import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        AppUser user = modelMapper.map(userRequestDto, AppUser.class);
        userRepository.save(user);
    }
}
