package com.JS_Blog.springBlog.blog.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scala.reflect.internal.SomePhase;
import scala.reflect.internal.Trees;

import java.security.cert.LDAPCertStoreParameters;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CommentsRepositoryTest extends Articles {

      @Autowired
      CommentsRepository commentsRepository;

      java.util.Date utilDate = new java.util.Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

      @Test
      void save() throws ParseException {
            //sql date형식으로 변환
            String date1 = sdf.format(utilDate);
            utilDate = new SimpleDateFormat("yyyy/MM/dd").parse(date1);

            Date date = new Date(utilDate.getTime());

            // 1. 2번 게시물의 댓글에 필요한 파라미터의 생성
            Comments params = Comments.builder()
                                      .commentNo(1)
                                      .articleNo(2)
                                      .cdt(date)
                                      .cid("박상준")
                                      .commentContent("1번 게시글의 내용입니다.")
                                      .userNo(1)
                                      .build();

            // 2. 댓글의 저장
            commentsRepository.save(params);

            //3. 댓글 내용 조회
            if (commentsRepository.findById(1)
                                  .isPresent()) {
                  Comments entity = commentsRepository.findById(1)
                                                      .get();

                  assertThat(entity.getCommentContent()).isEqualTo("1번 게시글의 내용입니다.");
                  assertThat(entity.getUserNo()).isEqualTo(1);
                  assertThat(entity.getCid()).isEqualTo("박상준");

            }
      }

      @Test
      void findAll() {
            //1. 전체 댓글 수 조회
            Long commentsCount = commentsRepository.count();

            //2. 전체 댓글 리스트 조회
            List<Comments> comments = commentsRepository.findAll();
      }

      @Test
      void delete() {
            if (commentsRepository.findById(1)
                                  .isPresent()) {
                  //댓글 조회
                  Comments entity = commentsRepository.findById(1)
                                                      .get();
                  //댓글 삭제
                  commentsRepository.delete(entity);
                  
            }
      }

}