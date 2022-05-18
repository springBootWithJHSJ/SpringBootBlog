package com.JS_Blog.springBlog.blog.service;

import com.JS_Blog.springBlog.blog.dto.ArticleDTO;
import com.JS_Blog.springBlog.blog.entity.Articles;


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

public interface ArticleService {

      Integer register(ArticleDTO dto);

      default Articles dtoToEntity(ArticleDTO dto) {
            Articles entity = Articles.builder()
                                      .articleNo(1)
                                      .articleTitle(dto.getArticle_title())
                                      .articleContent(dto.getArticle_content())
                                      .categoryNo(dto.getCategory_no())
                                      .articleShowYn(dto.getArticle_show_yn())
                                      .userNo(dto.getUser_no())
                                      .cdt(dto.getCdt())
                                      .build();
            return entity;
      }

}
