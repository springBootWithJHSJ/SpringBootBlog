package com.JS_Blog.springBlog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : Tags
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
public class Tags {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "tag_no")
      private int tagNo;
      @Basic
      @Column(name = "tag_name")
      private String tagName;
      @OneToMany(mappedBy = "tagsByTagId")
      private Collection<ArticlesTags> articlesTagsByTagNo;

      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            Tags tags = (Tags) o;
            return tagNo == tags.tagNo && Objects.equals(tagName, tags.tagName);
      }

      @Override
      public int hashCode() {
            return Objects.hash(tagNo, tagName);
      }

}
