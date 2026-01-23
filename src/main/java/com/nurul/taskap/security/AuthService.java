package com.nurul.taskap.security;

import com.nurul.taskap.dto.user.UserRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void register(UserRequestDto userRequestDto) {
        AppUser appUser = modelMapper.map(userRequestDto, AppUser.class);
        userRepository.save(appUser);
    }
}
