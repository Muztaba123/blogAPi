package com.blogApi.blogApi.payload;

import lombok.Data;

@Data
public class SignUpDto {

    private String email;
    private String name;
    private String username;
    private String password;

}
