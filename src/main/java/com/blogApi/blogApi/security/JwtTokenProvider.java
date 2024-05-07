package com.blogApi.blogApi.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private  int jwtExpirationInMs;
}
