package com.JS_Blog.springBlog.blog.controller;

import com.JS_Blog.springBlog.blog.dto.ArticleRequestDto;
import com.JS_Blog.springBlog.blog.entity.Category;
import com.JS_Blog.springBlog.blog.entity.CategoryRepository;
import com.JS_Blog.springBlog.blog.service.ArticleService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * packageName    : com.JS_Blog.springBlog.blog.controller
 * fileName       : ArticleApiController
 * author         : ipeac
 * date           : 2022-05-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-06        ipeac       최초 생성
 */
@Controller
@RequestMapping("/blog-article")
@Slf4j
public class ArticleApiController {

      private final CategoryRepository categoryRepository;
      private final ArticleService articleService;

      @Autowired
      //필드에 주입하지 않는다 > 순환참조를 방지합니다. https://madplay.github.io/post/why-constructor-injection-is-better-than-field-injection
      public ArticleApiController(CategoryRepository categoryRepository, ArticleService articleService) {
            this.categoryRepository = categoryRepository;
            this.articleService = articleService;
      }

      @GetMapping("/test")
      public String test() {
            throw new RuntimeException("런타임 에러!");
      }

      /**
       * @ 기능 : 카테고리의 리스트를 불러옵니다.
       */
      @ModelAttribute("category_list")
      public Map<Integer, String> categoty_list() {
            List<Category> categoryArrayList;
            categoryArrayList = categoryRepository.findAll();
            Map<Integer, String> categoryModel = new HashMap<>();

            for (Category category_one : categoryArrayList) {
                  categoryModel.put(category_one.getCategoryNo(), category_one.getCategoryName());
            }

            return categoryModel;
      }

      @GetMapping(value = "/article-write")
      public String goWritePage() {
            log.info("goWritePage() is invoked");

            return "write";
      }

      @PostMapping(value = "/write")
      public Integer write(@RequestBody final ArticleRequestDto articleRequestDto) {
            log.info("write() is invoked");


            return articleService.save(articleRequestDto);
      }

}
