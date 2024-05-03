package com.blogApi.blogApi.controller;

import com.blogApi.blogApi.payload.User;
import com.blogApi.blogApi.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService;
    @PostMapping("/userCreated")
    public ResponseEntity<User>createUser(@RequestBody User user)
    {
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
  }

}