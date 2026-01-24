package com.nurul.taskap.security;

import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findByName(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getName(),                 // username
                    user.getPassword(),             // encoded password
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                            .collect(Collectors.toList())
            );

        } else {
            throw new UsernameNotFoundException("Invalid User");
        }
    }

}
