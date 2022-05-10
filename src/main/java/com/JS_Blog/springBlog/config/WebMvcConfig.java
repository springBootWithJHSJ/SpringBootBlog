package com.JS_Blog.springBlog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * packageName    : com.JS_Blog.springBlog.config
 * fileName       : WebMvcConfig
 * author         : ipeac
 * date           : 2022-05-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11        ipeac       최초 생성
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("classpath:static/");
      }

}