package com.caru.caru.webservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * PostsSaveRequestDto
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 26.
 */
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	private String title;
	private String content;
	private String author;

	public Posts toEntity() {
		return Posts.builder().title(title).content(content).author(author).build();
	}
}
