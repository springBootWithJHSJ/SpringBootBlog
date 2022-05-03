package com.JS_Blog.springBlog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : ArticlesTags
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
@Table(name = "articles_tags", schema = "blog_project_db")
public class ArticlesTags {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "article_tag_no")
      private short articleTagNo;
      @Basic
      @Column(name = "article_no")
      private short articleNo;
      @Basic
      @Column(name = "tag_id")
      private short tagId;
      @ManyToOne
      @JoinColumn(name = "article_no", referencedColumnName = "article_no", nullable = false)
      private Articles articlesByArticleNo;
      @ManyToOne
      @JoinColumn(name = "tag_id", referencedColumnName = "tag_no", nullable = false)
      private Tags tagsByTagId;


      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            ArticlesTags that = (ArticlesTags) o;
            return articleTagNo == that.articleTagNo && articleNo == that.articleNo && tagId == that.tagId;
      }

      @Override
      public int hashCode() {
            return Objects.hash(articleTagNo, articleNo, tagId);
      }

}
