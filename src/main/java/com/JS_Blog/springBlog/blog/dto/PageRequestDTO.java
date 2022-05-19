package com.JS_Blog.springBlog.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * packageName    : com.JS_Blog.springBlog.blog.dto
 * fileName       : PageRequestDTO
 * author         : ipeac
 * date           : 2022-05-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19        ipeac       최초 생성
 */
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

      private Integer page;
      private Integer size;

      public PageRequestDTO() {
            this.page = 1;
            this.size = 6;
      }

      public Pageable getPageable(Sort sort) {
            return PageRequest.of(page - 1, size, sort);
      }

}
