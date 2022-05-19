package com.JS_Blog.springBlog.blog.service;

import com.JS_Blog.springBlog.blog.dto.ArticleDTO;
import com.JS_Blog.springBlog.blog.dto.PageRequestDTO;
import com.JS_Blog.springBlog.blog.dto.PageResultDTO;
import com.JS_Blog.springBlog.blog.entity.Articles;
import com.JS_Blog.springBlog.blog.entity.ArticlesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;


/**
 * packageName    : com.JS_Blog.springBlog.blog.service
 * fileName       : ArticleServiceImpl
 * author         : ipeac
 * date           : 2022-05-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18        ipeac       최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor //의존성 자동 주입
public class ArticleServiceImpl implements ArticleService {

      private final ArticlesRepository articlesRepository;

      @Override
      public Integer register(ArticleDTO dto) {
            log.info("register() is invoked");

            Articles entity = dtoToEntity(dto);

            log.info("entity = {}", entity);

            articlesRepository.save(entity);

            return entity.getArticleNo();
      }

      @Override
      public PageResultDTO<ArticleDTO, Articles> getList(PageRequestDTO requestDTO) {
            Pageable pageable = requestDTO.getPageable(Sort.by("articleNo")
                                                           .descending());

            Page<Articles> result = articlesRepository.findAll(pageable);

            Function<Articles, ArticleDTO> fn = (entity -> entityToDto(entity));

            return new PageResultDTO<>(result, fn);
      }

}
