package com.caru.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caru.core.service.Posts;
import com.caru.core.service.PostsSaveRequestDto;
import com.caru.core.service.PostsService;
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
	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}

	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}

	@GetMapping("/posts")
	public List<Posts> getPosts() {
		return postsService.findAll();
	}
}
