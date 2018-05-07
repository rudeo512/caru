package com.caru.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caru.core.domain.Posts;
import com.caru.core.domain.PostsRepository;
import com.caru.core.domain.PostsSaveRequestDto;
import lombok.AllArgsConstructor;

/**
 * WebRestController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 25.
 */
@RestController
@AllArgsConstructor
public class WebRestController {
	private PostsRepository postsRepository;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}

	@PostMapping("/posts")
	public List<Posts> savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
		return postsRepository.findAll();
	}

	@GetMapping("/posts")
	public List<Posts> getPosts() {
		return postsRepository.findAll();
	}
}
