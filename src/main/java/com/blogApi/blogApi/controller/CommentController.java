package com.blogApi.blogApi.controller;

import com.blogApi.blogApi.payload.CommentDTO;
import com.blogApi.blogApi.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("post/{id}/createComment")
    public ResponseEntity<CommentDTO> createComment(@PathVariable("id") Long id, @RequestBody CommentDTO commentDTO)
    {
        CommentDTO comment = commentService.createComment(id, commentDTO);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);

    }

    @GetMapping("/getAllCommentPostById/{id}")
    public ResponseEntity<List<CommentDTO>> getAllCommentPostById(@PathVariable("id") Long id)
    {
        List<CommentDTO> allCommentPostById = commentService.findAllCommentPostById(id);

        return new ResponseEntity<>(allCommentPostById,HttpStatus.OK);

    }
    @PutMapping("/post/{postId}/comment/{commentDto}")
    public ResponseEntity<CommentDTO> editComment(@PathVariable("postId") Long id,
                                                 @PathVariable("commentDto") Long DtoId,
                                                  @RequestBody CommentDTO commentDTO)
    {

        CommentDTO dto = commentService.editComment(id, DtoId, commentDTO);

        return  new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @DeleteMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteCommentById(
            @PathVariable("postId") Long postId,
            @PathVariable("commentId") Long commentId
    )
    {
        commentService.deleteCommentById(postId,commentId);

        return new ResponseEntity<>("delete post id'"+postId+"' and comment id " +
                "'"+commentId+"'",HttpStatus.OK);
    }
}
