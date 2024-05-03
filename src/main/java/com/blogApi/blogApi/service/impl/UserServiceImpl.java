package com.blogApi.blogApi.service.impl;

import com.blogApi.blogApi.payload.User;
import com.blogApi.blogApi.repositroy.UserRepose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
   private UserRepose userRepose;
    @Override
    public User createUser(User user) {

        User save = userRepose.save(user);
        return save;
    }
}
