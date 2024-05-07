package com.blogApi.blogApi.configSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder()
    {

        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails muz = User.builder().username("muz@123").password(passwordEncoder().encode("muz123")).roles("ADMIN").build();
//        UserDetails saif = User.builder().username("saif@123").password(passwordEncoder().encode("muz123")).roles("USER").build();
//        return new InMemoryUserDetailsManager(muz,saif);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/USERCRI/**").permitAll()
                .antMatchers("/auth/sigUp/**").permitAll()
                .antMatchers("/post/getAllPosts/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

}
