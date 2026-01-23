package com.nurul.taskap.security;

import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        AppUser user = userRepository.findByName(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found by this email."));

        Set<GrantedAuthority> grantedAuthorities = user.getRoles()
                .stream()
                .map((role -> new SimpleGrantedAuthority(role.getName())))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),grantedAuthorities);
    }
}
