package com.JS_Blog.springBlog.blog.controller;

import com.JS_Blog.springBlog.blog.dto.ArticleDTO;
import com.JS_Blog.springBlog.blog.dto.PageRequestDTO;
import com.JS_Blog.springBlog.blog.entity.Category;
import com.JS_Blog.springBlog.blog.entity.CategoryRepository;
import com.JS_Blog.springBlog.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.JS_Blog.springBlog.blog.controller.MainController.getIntegerStringMap;


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
            return getIntegerStringMap(categoryRepository);
      }

      @GetMapping(value = "/write")
      public String goWritePage() {
            log.info("goWritePage() is invoked");

            return "write";
      }

      @PostMapping(value = "/write")
      public String write(ArticleDTO articleDTO, RedirectAttributes redirectAttributes) {
            Date sqlDate = new java.sql.Date(System.currentTimeMillis());

            log.info("write() is invoked");
            log.info("articleDTO = {}", articleDTO);

            //Article_show_yn = "Y"
            articleDTO.setArticle_show_yn("Y");
            //cdt 오늘 날짜
            articleDTO.setCdt(sqlDate);


            // 새로 추가된 엔티티의 번호
            Integer article_no = articleService.register(articleDTO);

            redirectAttributes.addFlashAttribute("msg", article_no);

            return "redirect:/";
      }

      @GetMapping("/read")
      public void read(Integer article_no, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
            log.info("read() is invoked");
            log.info("article_no = {}", article_no);

            ArticleDTO dto = articleService.read(article_no);

            model.addAttribute("dto", dto);
      }

}
