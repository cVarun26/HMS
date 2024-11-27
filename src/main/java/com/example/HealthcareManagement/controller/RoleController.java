package com.example.HealthcareManagement.controller;

import com.example.HealthcareManagement.dto.UserDTO;
import com.example.HealthcareManagement.exception.RoleException;
import com.example.HealthcareManagement.model.User;
import com.example.HealthcareManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/role-selection")
public class RoleController {


    @Autowired
    private UserRepo userRepo;


    @PostMapping("/assignRole")
    public ResponseEntity<String> selectRole(@RequestParam String email, @RequestParam String role) throws RoleException {

        User user = userRepo.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));

        if ((!Arrays.asList("ROLE_DOCTOR","ROLE_PATIENT").contains(role))){
            return ResponseEntity.badRequest().body("Invalid");
        }

        user.setRole(role);
        userRepo.save(user);
        return ResponseEntity.ok("Role Assigned!");
    }

    @GetMapping("/success")
    public ResponseEntity<String> success(){
        return ResponseEntity.ok("Logged in");
    }


//        Optional<User> userOptional=userRepo.findByEmail(email);
//        if(userOptional.isEmpty()){
//            return ResponseEntity.badRequest().body("User not found");
//        }
//
//        User user=userOptional.get();
//        user.setRole(role);
//        userRepo.save(user);
//
//        return ResponseEntity.ok("Role assigned!");

//        OAuth2User oAuth2User =token.getPrincipal();
//
//        String email=oAuth2User.getAttribute("email");
//
//        if(email==null){
//            return ResponseEntity.badRequest().body("Email not found");
//        }
//
//        Optional<User> userOptional = userRepo.findByEmail(email);
//        if(userOptional.isEmpty()){
//            return ResponseEntity.badRequest().body("User not found");
//        }
//
//        User user = userOptional.get();
//
//        if(!role.startsWith("ROLE_")){
//            return ResponseEntity.badRequest().body("Invalid format");
//        }
//        user.setRole(role);
//
//        userRepo.save(user);
//
//        return ResponseEntity.ok("Role Assigned");



}
