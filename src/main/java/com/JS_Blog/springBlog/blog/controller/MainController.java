package com.JS_Blog.springBlog.blog.controller;

import com.JS_Blog.springBlog.blog.dto.PageRequestDTO;
import com.JS_Blog.springBlog.blog.entity.Category;
import com.JS_Blog.springBlog.blog.entity.CategoryRepository;
import com.JS_Blog.springBlog.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.PipedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * packageName    : com.JS_Blog.springBlog.blog.controller
 * fileName       : MainController
 * author         : ipeac
 * date           : 2022-05-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10        ipeac       최초 생성
 */

@Controller
@Log4j2
@RequiredArgsConstructor //자동주입
public class MainController {

      private final CategoryRepository categoryRepository;
      private final ArticleService service;

      @RequestMapping(value = "/", method = RequestMethod.GET)
      public String main(PageRequestDTO pageRequestDTO, Model model) {
            log.info("main() is invoked");

            model.addAttribute("result", service.getList(pageRequestDTO));

            return "/main";
      }

      /**
       * @ 기능 : 카테고리의 리스트를 불러옵니다.
       */
      @ModelAttribute("category_list")
      public Map<Integer, String> categoty_list() {
            return getIntegerStringMap(categoryRepository);
      }

      static Map<Integer, String> getIntegerStringMap(CategoryRepository categoryRepository) {
            List<Category> categoryArrayList;
            categoryArrayList = categoryRepository.findAll();
            Map<Integer, String> categoryModel = new HashMap<>();

            for (Category category_one : categoryArrayList) {
                  categoryModel.put(category_one.getCategoryNo(), category_one.getCategoryName());
            }

            return categoryModel;
      }

}
