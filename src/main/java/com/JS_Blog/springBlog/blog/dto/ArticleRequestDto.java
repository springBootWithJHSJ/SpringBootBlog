package com.JS_Blog.springBlog.blog.dto;

import com.JS_Blog.springBlog.blog.entity.Articles;
import lombok.Data;

import java.sql.Date;


/**
 * packageName    : com.JS_Blog.springBlog.blog.dto
 * fileName       : articleDto
 * author         : ipeac
 * date           : 2022-05-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18        ipeac       최초 생성
 */
@Data
public class ArticleRequestDto {

      private String articleTitle;
      private String articleContent;
      private Integer categoryNo;
      private String articleShowYn;
      private Date cdt;
      private String cid;
      private Integer userNo;

      public Articles toEntity() {
            return Articles.builder()
                           .articleTitle(articleTitle)
                           .articleContent(articleContent)
                           .categoryNo(categoryNo)
                           .articleShowYn(articleShowYn)
                           .cdt(cdt)
                           .cid(cid)
                           .userNo(userNo)
                           .build();
      }

}
