package com.caru.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class WebController {
	@GetMapping("/")
	public String main(Model model) {
		return "main";
	}
}
