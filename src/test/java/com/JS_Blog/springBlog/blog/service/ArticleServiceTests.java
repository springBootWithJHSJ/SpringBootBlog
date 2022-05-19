package com.JS_Blog.springBlog.blog.service;

import com.JS_Blog.springBlog.blog.dto.ArticleDTO;
import com.JS_Blog.springBlog.blog.dto.PageRequestDTO;
import com.JS_Blog.springBlog.blog.dto.PageResultDTO;
import com.JS_Blog.springBlog.blog.entity.Articles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


/**
 * packageName    : com.JS_Blog.springBlog.blog.service
 * fileName       : ArticleServiceTests
 * author         : ipeac
 * date           : 2022-05-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18        ipeac       최초 생성
 */
@SpringBootTest
public class ArticleServiceTests {

      @Autowired
      private ArticleService service;

      @Test
      public void testRegister() {
            Date sqlDate = new java.sql.Date(System.currentTimeMillis());
            ArticleDTO articleDTO = ArticleDTO.builder()
                                              .article_no(1)
                                              .article_title("게시글 제목")
                                              .article_content("게시글 내용")
                                              .category_no(1)
                                              .article_show_yn("Y")
                                              .user_no(1)
                                              .cdt(sqlDate)
                                              .build();
            System.out.println("articleDTO = " + service.register(articleDTO));
      }

      @Test
      public void testList() {

            PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                                                          .page(1)
                                                          .size(6)
                                                          .build();

            PageResultDTO<ArticleDTO, Articles> resultDTO = service.getList(pageRequestDTO);
            System.out.println("resultDTO.isPrev() = " + resultDTO.isPrev());
            System.out.println("resultDTO.isNext() = " + resultDTO.isNext());
            System.out.println("resultDTO.getTotalPage() = " + resultDTO.getTotalPage());
            ;
            
            System.out.println("======================================================");
            for (ArticleDTO articleDTO : resultDTO.getDtoList()) {
                  System.out.println(articleDTO);

            }
            System.out.println("======================================================");
            resultDTO.getPageList()
                     .forEach(System.out::println);

      }

}
