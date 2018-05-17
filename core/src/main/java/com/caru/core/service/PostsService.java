package com.caru.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@EnableJpaAuditing
public class PostsService {
	private PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}

	public List<Posts> findAll() {
		return postsRepository.findAll();
	}


	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc()
			.map(PostsMainResponseDto::new)
			.collect(Collectors.toList());
	}

}
