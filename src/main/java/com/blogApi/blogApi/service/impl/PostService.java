package com.blogApi.blogApi.service.impl;

import com.blogApi.blogApi.payload.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
  List<PostDto> getAllPosts();

  // get one post base on Id
  PostDto getOnePost(Long id);

  //post delete base on Id
   void deletePost(Long id);

  //post edit base on id

    PostDto editPost(PostDto postDto,Long id);

    List<PostDto> getAllPostsPageable(int pageNo,int pageSize,String sortBy,String sortDir);
    
}
