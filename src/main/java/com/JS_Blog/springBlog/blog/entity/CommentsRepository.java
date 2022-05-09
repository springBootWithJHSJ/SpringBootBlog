package com.JS_Blog.springBlog.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : CommentsRepository
 * author         : ipeac
 * date           : 2022-05-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10        ipeac       최초 생성
 */

public interface CommentsRepository extends JpaRepository<Articles, Integer> {
      
}
