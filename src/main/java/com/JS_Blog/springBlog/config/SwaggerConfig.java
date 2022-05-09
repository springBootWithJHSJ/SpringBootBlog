package com.JS_Blog.springBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * packageName    : com.JS_Blog.springBlog.config
 * fileName       : SwaggerConfig
 * author         : ipeac
 * date           : 2022-05-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-03        ipeac       최초 생성
 */

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

      private static final String API_NAME = "Blog API";
      private static final String API_VERSION = "0.0.1";
      private static final String API_DESCRIPTION = "Blog API 명세서";

      //swagger 2.9.2 버전 리소스 등록
      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) { //spring-security와 연결할 때 이 부분을 작성하지 않으면 404에러가 뜬다.
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
      }

      @Bean
      public Docket api() { //swagger를 연결하기 위한 Bean 작성
            return new Docket(DocumentationType.SWAGGER_2).select()
                                                          .apis(RequestHandlerSelectors.any())
                                                          .paths(PathSelectors.any())
                                                          .build()
                                                          .apiInfo(apiInfo());
      }

      private ApiInfo apiInfo() { //선택
            return new ApiInfoBuilder().title("Blog") //자신에게 맞는 타이틀을 작성해준다.
                                       .description("backend api document") //알맞는 description을 작성해준다.
                                       .version("0.1") //알맞는 버전을 작성해준다.
                                       .build();
      }

}
