package com.caru.web.controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WebControllerTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 05. 10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void 메인페이지_로딩() {
		//when
		String body = this.restTemplate.getForObject("/", String.class);

		//then
		assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
	}
}
