package com.caru.core.service;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostsRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 04. 26.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
