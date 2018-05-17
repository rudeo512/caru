package com.caru.core.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import lombok.Getter;

/**
 * PostsMainResponseDto
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 05. 17.
 */
@Getter
public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String author;
	private String modifiedDate;

	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime(entity.getModifiedDate());
	}

	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
			.map(formatter::format)
			.orElse("");
	}
}
