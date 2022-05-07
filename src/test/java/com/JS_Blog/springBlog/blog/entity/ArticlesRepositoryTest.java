package com.JS_Blog.springBlog.blog.entity;

import com.JS_Blog.springBlog.SpringBlogApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ArticlesRepositoryTest {

      private static final Logger logger = LoggerFactory.getLogger(SpringBlogApplication.class);
      LocalDate now = LocalDate.now();

      @Autowired
      ArticlesRepository articlesRepository;

      @Test
      void save() {
            // 1. 게시물의 파라미터의 생성
            Articles params = Articles.builder()
                                      .articleNo(1)
                                      .articleContent("게시글의 내용입니다.")
                                      .articleTitle("게시물의 제목입니다.")
                                      .articleShowYn("Y")
                                      .cdt(Date.valueOf(now))
                                      .cid("박상준")
                                      .userNo(1)
                                      .categoryNo(1)
                                      .build();


            System.out.println("params = " + params.getArticleContent());

            //2. 게시물 저장
            articlesRepository.save(params);

            //3. 게시물 정보 조회
            if (articlesRepository.findById(1)
                                  .isPresent()) {
                  Articles entity = articlesRepository.findById(1)
                                                      .get();
                  assertThat(entity.getArticleTitle()).isEqualTo("게시물의 제목입니다.");
                  assertThat(entity.getArticleContent()).isEqualTo("게시글의 내용입니다.");
                  assertThat(entity.getCid()).isEqualTo("박상준");
            }

      }

      @Test
      void findAll() {
            // 1.  전체 게시글 수 조회
            Long articleCount = articlesRepository.count();

            //2. 전체 게시글 리스트 조회
            List<Articles> articles = articlesRepository.findAll();
      }

      @Test
      void delete() {
            if (articlesRepository.findById(1)
                                  .isPresent()) {
                  //1. 게시글의 조회
                  Articles entity = articlesRepository.findById(1)
                                                      .get();
                  //2. 게시글의 삭제
                  articlesRepository.delete(entity);
            }

      }

}