package com.JS_Blog.springBlog.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
@RequestMapping("/")
@Log4j2
public class MainController {

      @RequestMapping(value = "/", method = RequestMethod.GET)
      public String main() {
            log.info("main() is invoked");
            
            return "main";
      }

}
