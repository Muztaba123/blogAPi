package com.blogApi.blogApi.repositroy;


import com.blogApi.blogApi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReposetroy extends JpaRepository<Post,Long> {
}
