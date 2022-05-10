package com.JS_Blog.springBlog.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
@RestController
@RequestMapping("/blog-article")
public class ArticleApiController {

      @GetMapping("/test")
      public String test() {
            throw new RuntimeException("런타임 에러!");
      }

      @GetMapping("/list")
      public String list(@RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
            
            return "main";
      }

}
