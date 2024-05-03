package com.blogApi.blogApi.repositroy;

import com.blogApi.blogApi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReposetroy extends JpaRepository<Comment,Long> {

 List<Comment> findByPostId(Long id);

}
