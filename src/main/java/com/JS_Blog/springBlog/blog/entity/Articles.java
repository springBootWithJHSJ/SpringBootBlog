package com.JS_Blog.springBlog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : Articles
 * author         : ipeac
 * date           : 2022-05-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-03        ipeac       최초 생성
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Articles {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "article_no", nullable = false)
      private Integer articleNo;

      @Basic
      @Column(name = "article_title", nullable = false)
      private String articleTitle;

      @Basic
      @Column(name = "article_content", nullable = false)
      private String articleContent;

      @Basic
      @Column(name = "article_show_yn", nullable = false)
      private String articleShowYn;

      @Basic
      @Column(name = "UDT")
      private Date udt;

      @Basic
      @Column(name = "CDT", nullable = false)
      private Date cdt;

      @Column(name = "UID")
      private String uid;

      @Column(name = "thumbnail")
      private String thumbnail;

      @Column(name = "user_no", nullable = false, insertable = false, updatable = false)
      private Integer userNo;

      @Column(name = "category_no", insertable = false, updatable = false)
      private Integer categoryNo;

      @ManyToOne
      @JoinColumn(name = "user_no", referencedColumnName = "user_no")
      private Users usersByUserNo;

      @ManyToOne
      @JoinColumn(name = "category_no", referencedColumnName = "category_no")
      private Category categoryByCategoryNo;

      @OneToMany(mappedBy = "articlesByArticleNo")
      private Collection<ArticlesTags> articlesTagsByArticleNo;

      @OneToMany(mappedBy = "articlesByArticleNo")
      private Collection<Comments> commentsByArticleNo;

      @OneToMany(mappedBy = "articlesByArticleNo")
      private Collection<Likes> likesByArticleNo;

}
