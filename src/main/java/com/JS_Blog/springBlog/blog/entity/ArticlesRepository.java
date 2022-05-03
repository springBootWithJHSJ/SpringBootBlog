package com.JS_Blog.springBlog.blog.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ArticlesRepository extends JpaRepository<Articles, Integer>, JpaSpecificationExecutor<Articles> {

}