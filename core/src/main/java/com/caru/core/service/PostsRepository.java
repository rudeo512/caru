package com.caru.core.service;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PostsRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 26.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
	@Query("SELECT p " +
		"FROM Posts p " +
		"ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();
}
