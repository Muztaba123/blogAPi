package com.blogApi.blogApi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint {

    @Autowired
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException authException)throws IOException, ServletException
    {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                authException.getMessage());
    }

}
