package com.blogApi.blogApi.repositroy;

import com.blogApi.blogApi.payload.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepostroy extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
