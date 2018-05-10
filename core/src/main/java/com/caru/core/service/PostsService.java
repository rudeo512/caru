package com.caru.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caru.core.domain.PostsRepository;
import com.caru.core.domain.PostsSaveRequestDto;
import lombok.AllArgsConstructor;

/**
 * PostsService
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 05. 10.
 */

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}
