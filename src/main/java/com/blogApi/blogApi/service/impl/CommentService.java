package com.blogApi.blogApi.service.impl;

import com.blogApi.blogApi.payload.CommentDTO;

import java.util.List;

public interface CommentService {

 CommentDTO createComment(Long PostId ,CommentDTO commentDTO);
 List<CommentDTO> findAllCommentPostById(Long id);

 CommentDTO editComment(Long postId, Long dtoId, CommentDTO commentDTO);

 void deleteCommentById(Long postId, Long commentId);
}
