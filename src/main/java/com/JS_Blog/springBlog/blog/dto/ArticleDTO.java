package com.JS_Blog.springBlog.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * packageName    : com.JS_Blog.springBlog.blog.dto
 * fileName       : ArticleDTO
 * author         : ipeac
 * date           : 2022-05-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18        ipeac       최초 생성
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDTO {

      private Integer article_no;
      private String article_title;
      private String article_content;
      private Integer category_no;
      private String article_show_yn;
      private Integer user_no;
      private Date cdt;

}
