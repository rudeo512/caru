package com.caru.core.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.caru.core.domain.PostsRepository;

/**
 * PostServiceTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 05. 10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;

	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void Dto데이터가_posts테이블에_저장된다() {

	}
}
