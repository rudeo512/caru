package com.caru.core.service;

import static org.assertj.core.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PostServiceTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 05. 10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostServiceTest {

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;

	@Test
	public void Dto데이터가_posts테이블에_저장된다() {
		//given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
			.author("jojoldu@gmail.com")
			.content("테스트")
			.title("테스트 타이틀")
			.build();

		//when
		Long result = postsService.save(dto);

		//then
		Posts posts = postsRepository.findById(result).get();
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
}
