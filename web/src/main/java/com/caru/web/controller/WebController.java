package com.caru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.caru.core.service.PostsService;
import lombok.AllArgsConstructor;

/**
 * WebRestController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 25.
 */
@Controller
@AllArgsConstructor
public class WebController {
	private PostsService postsService;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "main";
	}
}
