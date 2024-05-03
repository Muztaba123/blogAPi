package com.blogApi.blogApi.service.impl;

import com.blogApi.blogApi.entities.Post;
import com.blogApi.blogApi.exception.ResourceNotFoundException;
import com.blogApi.blogApi.payload.PostDto;
import com.blogApi.blogApi.repositroy.PostReposetroy;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService {


  private PostReposetroy postReposetroy;
  private ModelMapper modelMapper;

  public PostServiceimpl(PostReposetroy postReposetroy,ModelMapper modelMapper)
  {
      this.postReposetroy=postReposetroy;
      this.modelMapper=modelMapper;
  }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);
        Post postEnity = postReposetroy.save(post);
        PostDto dto = mapToDTO(postEnity);
        return dto;
       }
    public Post mapToEntity(PostDto postDto)
    {
        Post post = modelMapper.map(postDto, Post.class);

        return post;
    }

    public PostDto mapToDTO(Post post)
    {
        PostDto dto = modelMapper.map(post, PostDto.class);

        return dto;
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postReposetroy.findAll();
        List<PostDto> collect = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PostDto getOnePost(Long id) {
        Post post1 = postReposetroy.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );

        PostDto dto = mapToDTO(post1);

        return dto;
    }

    @Override
    public void deletePost(Long id) {

        Post post = postReposetroy.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)

        );
        postReposetroy.deleteById(id);

    }

    @Override
    public PostDto editPost(PostDto postDto,Long id) {

        Post post = postReposetroy.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post save = postReposetroy.save(post);
        PostDto dto = mapToDTO(save);
        return dto;
    }

    @Override
    public List<PostDto> getAllPostsPageable(int pageNo, int pageSize,String sortBy,String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable= PageRequest.of(pageNo,pageSize, sort);
        Page<Post> posts = postReposetroy.findAll(pageable);
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

}
