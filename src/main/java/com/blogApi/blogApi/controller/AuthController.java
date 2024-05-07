package com.blogApi.blogApi.controller;

import com.blogApi.blogApi.entities.Post;
import com.blogApi.blogApi.payload.Role;
import com.blogApi.blogApi.payload.SignUpDto;
import com.blogApi.blogApi.payload.User;
import com.blogApi.blogApi.repositroy.PostReposetroy;
import com.blogApi.blogApi.repositroy.RoleRepostroy;
import com.blogApi.blogApi.repositroy.UserRepose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepose userRepose;

    @Autowired
    private RoleRepostroy roleRepostroy;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sigUp")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto sigUpDto)
    {
        //add check the username exists in db
        if(userRepose.existsByUsername(sigUpDto.getUsername()))
        {
            new ResponseEntity<>("username is already taken", HttpStatus.BAD_REQUEST);
        }
        if(userRepose.existsByEmail(sigUpDto.getEmail()))
        {
            new ResponseEntity<>("email is already taken",HttpStatus.BAD_REQUEST);
        }

        User user =new User();

        user.setEmail(sigUpDto.getEmail());
        user.setName(sigUpDto.getName());
        user.setUsername(sigUpDto.getUsername());
        user.setPassword(passwordEncoder.encode(sigUpDto.getPassword()));

        Role roles = roleRepostroy.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        userRepose.save(user);

        return new  ResponseEntity<>("User registered successfully",HttpStatus.OK);

    }

    @GetMapping("/login")
    public ResponseEntity<?> login()
    {
        return new ResponseEntity<>("",HttpStatus.OK);

    }
}
