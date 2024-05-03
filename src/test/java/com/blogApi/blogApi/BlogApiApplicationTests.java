package com.blogApi.blogApi;

import com.blogApi.blogApi.entities.Post;
import com.blogApi.blogApi.payload.PostDto;
import com.blogApi.blogApi.payload.Role;
import com.blogApi.blogApi.payload.User;
import com.blogApi.blogApi.repositroy.PostReposetroy;
import com.blogApi.blogApi.repositroy.UserRepose;
import com.blogApi.blogApi.service.impl.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class BlogApiApplicationTests {
	
	@Autowired
	private PostService postService;
	@Autowired
	private PostReposetroy postReposetroy;

	@Autowired
	private UserRepose userRepose;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {

//		long i=2;
//
//		Optional<Post> byId = postReposetroy.findById(i);
//		Post post = byId.get();
//		PostDto dto=new PostDto();
//		dto.setId(post.getId());
//		dto.setTitle("kojhnbgv");
//		dto.setDescription("polhjubgvfcgyhuiolkjnhbgv");
//		dto.setContent("lokijuhgbvfcfvghyuiolpkjmnhb");
//		post.setId(dto.getId());
//		post.setTitle(dto.getTitle());
//		post.setTitle(dto.getDescription());
//		post.setContent(dto.getContent());
//		postReposetroy.save(post);

	}



	//@Test
	public void getUser() {

		Role role=new Role();
		role.setName("ADMIN");
		Set s=new HashSet();
		s.add(role);
		User user=new User();
		user.setEmail("muztaba1@gmail.com");
		user.setUsername("Muztaba@123");
		user.setPassword(passwordEncoder.encode("muz123"));
		user.setRoles(s);
		User save = userRepose.save(user);
		Assertions.assertNotNull(save);
	}

	void checkUser()
		{

		}






}
