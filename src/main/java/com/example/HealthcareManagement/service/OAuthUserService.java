package com.example.HealthcareManagement.service;

import com.example.HealthcareManagement.dto.UserDTO;
import com.example.HealthcareManagement.exception.RoleException;
import com.example.HealthcareManagement.model.User;
import com.example.HealthcareManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class OAuthUserService extends DefaultOAuth2UserService {

    @Autowired
    private final UserRepo userRepo;

    public OAuthUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        User user = userRepo.findByEmail(email).orElseGet(() -> {

            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setRole(null);
            userRepo.save(newUser);
            return newUser;
        });

        return new UserDTO(user,oAuth2User.getAttributes());

    }
}
