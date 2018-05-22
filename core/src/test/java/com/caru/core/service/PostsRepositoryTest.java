package com.caru.core.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PostsRepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;

	@Test
	public void 게시글저장_불러오기() {
		//given
		Posts posts = postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jojoldu@gmail.com").build());

		// when
		Posts result = postsRepository.findById(posts.getId()).get();

		// then
		assertThat(result.getTitle(), is("테스트 게시글"));
		assertThat(result.getContent(), is("테스트 본문"));
	}

	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.now();

		// when
		Posts posts = postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jojoldu@gmail.com").build());

		//then
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}



