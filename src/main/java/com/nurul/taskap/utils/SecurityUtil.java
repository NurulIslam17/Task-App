package com.nurul.taskap.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    public Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getCurrentUsername()
    {
        Authentication auth = getAuthentication();
        return auth.getName();
    }

    public  boolean hasRole(String role)
    {
        Authentication auth = getAuthentication();
        return  auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals(role));
    }
}
