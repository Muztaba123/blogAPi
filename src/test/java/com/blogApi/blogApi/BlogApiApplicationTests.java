package com.blogApi.blogApi;

import com.blogApi.blogApi.entities.Post;
import com.blogApi.blogApi.payload.PostDto;
import com.blogApi.blogApi.payload.Role;
import com.blogApi.blogApi.payload.SignUpDto;
import com.blogApi.blogApi.payload.User;
import com.blogApi.blogApi.repositroy.PostReposetroy;
import com.blogApi.blogApi.repositroy.RoleRepostroy;
import com.blogApi.blogApi.repositroy.UserRepose;
import com.blogApi.blogApi.service.impl.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
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

	@Autowired
	private RoleRepostroy roleRepostroy;

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




	//@Test
	void singUp()
		{
			SignUpDto dto=new SignUpDto();
			dto.setEmail("kijuhgfv");
			dto.setName("polkijuhygft");
			dto.setUsername("lokijhugfvcx");
			dto.setPassword(passwordEncoder.encode("poljuhygtflkjhg"));
			User user=new User();
			user.setEmail(dto.getEmail());
			user.setName(dto.getName());
			user.setUsername(dto.getUsername());
			user.setPassword(passwordEncoder.encode(dto.getPassword()));
			Role role = roleRepostroy.findByName("ROLE_ADMIN").get();
			user.setRoles(Collections.singleton(role));

			userRepose.save(user);


		}






}
