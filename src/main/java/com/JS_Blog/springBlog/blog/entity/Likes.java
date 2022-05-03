package com.JS_Blog.springBlog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : Likes
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
public class Likes {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "like_no")
      private int likeNo;
      @Basic
      @Column(name = "user_no", insertable = false, updatable = false)
      private int userNo;
      @Basic
      @Column(name = "article_no", insertable = false, updatable = false)
      private int articleNo;
      @ManyToOne
      @JoinColumn(name = "user_no", referencedColumnName = "user_no", nullable = false)
      private Users usersByUserNo;
      @ManyToOne
      @JoinColumn(name = "article_no", referencedColumnName = "article_no", nullable = false)
      private Articles articlesByArticleNo;

      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            Likes likes = (Likes) o;
            return likeNo == likes.likeNo && userNo == likes.userNo && articleNo == likes.articleNo;
      }

      @Override
      public int hashCode() {
            return Objects.hash(likeNo, userNo, articleNo);
      }

}
