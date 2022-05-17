package com.JS_Blog.springBlog.blog.service;

import com.JS_Blog.springBlog.blog.dto.ArticleRequestDto;
import com.JS_Blog.springBlog.blog.entity.Articles;
import com.JS_Blog.springBlog.blog.entity.ArticlesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * packageName    : com.JS_Blog.springBlog.blog.service
 * fileName       : ArticleService
 * author         : ipeac
 * date           : 2022-05-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18        ipeac       최초 생성
 */
@Service
@RequiredArgsConstructor
public class ArticleService {

      private final ArticlesRepository articlesRepository;

      /**
       * 게시글 생성
       *
       * @return Integer
       */
      @Transactional
      public Integer save(final ArticleRequestDto params) {
            Articles entity = articlesRepository.save(params.toEntity());
            return entity.getArticleNo();
      }

}
