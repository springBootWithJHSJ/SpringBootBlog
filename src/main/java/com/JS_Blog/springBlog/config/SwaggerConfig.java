package com.JS_Blog.springBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
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
public class SwaggerConfig {

      private static final String API_NAME = "Blog API";
      private static final String API_VERSION = "0.0.1";
      private static final String API_DESCRIPTION = "Blog API 명세서";


      @Bean
      public Docket api() {
            // parameterBuilder : API 테스트시 모든 API에 전역 파라미터를 설정
            // 해당 소스는 모든 API 테스트시 HEADER 에 'Autorization' 이라는 값을 추가합니다.
            Parameter parameterBuilder = new ParameterBuilder().name(HttpHeaders.AUTHORIZATION)
                                                               .description("Access Tocken")
                                                               .modelRef(new ModelRef("string"))
                                                               .parameterType("header")
                                                               .required(false)
                                                               .build();

            List<Parameter> globalParamters = new ArrayList<>();
            globalParamters.add(parameterBuilder);

            return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(globalParamters)
                                                          .apiInfo(apiInfo()) //
                                                          .select()
                                                          .apis(RequestHandlerSelectors.basePackage(
                                                              "com.JS_Blog.springBlog")) //Swagger 를 적용할 클래스의 패키지 명 기재
                                                          .paths(PathSelectors.any()) // 해당 package 하위의 모든 url 에 적용한다.
                                                          .build();
      }

      public ApiInfo apiInfo() { // 해당 API의 이름은 무엇이며 현재 버전은 어떻게 되는지 해당 API 에 대한 정보를 적어준다.
            return new ApiInfoBuilder().title(API_NAME)
                                       .version(API_VERSION)
                                       .description(API_DESCRIPTION)
                                       .build();
      }

}
