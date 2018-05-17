package com.caru.core.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
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
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() { /** 이후 테스트 코드에 영향을 끼치지 않기 위해 테스트 메소드가 끝날때 마다 respository 전체 비우는 코드 **/
		postsRepository.deleteAll();
	}

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
		Posts posts = postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jojoldu@gmail.com").build());

		// when
		Posts result = postsRepository.findById(posts.getId()).get();

		//then
		assertTrue(result.getCreatedDate().isAfter(now));
		assertTrue(result.getModifiedDate().isAfter(now));
	}
}



