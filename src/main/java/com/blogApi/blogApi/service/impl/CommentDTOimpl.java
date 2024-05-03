package com.blogApi.blogApi.service.impl;

import com.blogApi.blogApi.entities.Comment;
import com.blogApi.blogApi.entities.Post;
import com.blogApi.blogApi.exception.ResourceNotFoundException;
import com.blogApi.blogApi.payload.CommentDTO;
import com.blogApi.blogApi.repositroy.CommentReposetroy;
import com.blogApi.blogApi.repositroy.PostReposetroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentDTOimpl implements CommentService{

    private PostReposetroy postReposetroy;
    private CommentReposetroy commentReposetroy;

    public CommentDTOimpl(PostReposetroy postReposetroy, CommentReposetroy commentReposetroy) {
        this.postReposetroy = postReposetroy;
        this.commentReposetroy = commentReposetroy;
    }

    @Override
    public CommentDTO createComment(Long postId,CommentDTO commentDTO) {

        Post post = postReposetroy.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("", "", postId)
        );
        Comment comment = mapToEntity(commentDTO);
        comment.setPost(post);
        Comment save = commentReposetroy.save(comment);

        CommentDTO dto = mapToDto(save);

        return dto;
    }

    @Override
    public List<CommentDTO> findAllCommentPostById(Long id) {
        List<Comment> byPostId = commentReposetroy.findByPostId(id);
        List<CommentDTO> collect = byPostId.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CommentDTO editComment(Long postId, Long dtoId, CommentDTO commentDTO) {

        postReposetroy.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post","Id",postId)
        );

        Comment comment = commentReposetroy.findById(dtoId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "Id", dtoId)
                );

        //Comment comment1=new Comment();
        comment.setBody(commentDTO.getBody());
        comment.setEmail(commentDTO.getEmail());
        comment.setName(commentDTO.getName());

        Comment comment2 = commentReposetroy.save(comment);

        CommentDTO dto = mapToDto(comment2);
          return dto;
    }

    @Override
    public void deleteCommentById(Long postId, Long commentId) {

        Post post = postReposetroy.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "Id", postId)
                    );
        Comment comment = commentReposetroy.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "Id", commentId)
        );
                  commentReposetroy.deleteById(comment.getId());
    }

    public Comment mapToEntity(CommentDTO commentDTO)
    {
        // body, email, name,post
        Comment comment=new Comment();
        comment.setBody(commentDTO.getBody());
        comment.setEmail(commentDTO.getEmail());
        comment.setName(commentDTO.getName());
        return comment;
    }

    public CommentDTO mapToDto(Comment comment)
    {
        CommentDTO dto=new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        dto.setName(comment.getName());
        return dto;
    }

}
                                                                                                         