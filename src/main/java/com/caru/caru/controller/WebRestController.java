package com.caru.caru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebRestController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 25.
 */
@RestController
public class WebRestController {
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
}
