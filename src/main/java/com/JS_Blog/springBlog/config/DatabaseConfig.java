package com.JS_Blog.springBlog.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.CircuitBreaker;

import javax.sql.DataSource;
import java.awt.image.Kernel;


/**
 * packageName    : com.JS_Blog.springBlog.config
 * fileName       : DatabaseConfig
 * author         : ipeac
 * date           : 2022-05-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-03        ipeac       최초 생성
 */
@Configuration
@PropertySource("classpath:/application.properties") //설정 위치 잡기
public class DatabaseConfig {

      @Bean
      @ConfigurationProperties(prefix = "spring.datasource.hikari")
      public HikariConfig hikariConfig() {
            return new HikariConfig();
      }

      @Bean
      public DataSource dataSource() {
            return new HikariDataSource(hikariConfig());
      }

}
