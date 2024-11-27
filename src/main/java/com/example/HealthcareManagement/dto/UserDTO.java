package com.example.HealthcareManagement.dto;

import com.example.HealthcareManagement.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO implements OAuth2User {

    private final User user;
    private final Map<String, Object> attributes;

    public UserDTO(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.singletonList(
               new SimpleGrantedAuthority(user.getRole())
       );
    }

    @Override
    public String getName() {
        return user.getEmail();
    }

    public User getUser(){
        return user;
    }
}
