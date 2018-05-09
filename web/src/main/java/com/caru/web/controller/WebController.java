package com.caru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping("/")
	public String hello() {
		return "main";
	}
}
