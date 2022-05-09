package com.JS_Blog.springBlog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : Comments
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
public class Comments {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "comment_no")
      private Integer commentNo;
      @Basic
      @Column(name = "comment_nm")
      private String commentNm;
      @Basic
      @Column(name = "comment_pw")
      private String commentPw;
      @Basic
      @Column(name = "comment_content")
      private String commentContent;
      @Basic
      @Column(name = "CDT")
      private Date cdt;
      @Basic
      @Column(name = "UDT")
      private Date udt;
      @Basic
      @Column(name = "UID")
      private String uid;
      @Basic
      @Column(name = "CID")
      private String cid;
      @Basic
      @Column(name = "user_no", insertable = false, updatable = false)
      private Integer userNo;
      @Basic
      @Column(name = "article_no", insertable = false, updatable = false, nullable = false)
      private Integer articleNo;

      @ManyToOne
      @JoinColumn(name = "user_no", referencedColumnName = "user_no")
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
            Comments comments = (Comments) o;
            return commentNo == comments.commentNo && articleNo == comments.articleNo && Objects.equals(commentNm,
                                                                                                        comments.commentNm) && Objects.equals(
                commentPw, comments.commentPw) && Objects.equals(commentContent,
                                                                 comments.commentContent) && Objects.equals(cdt,
                                                                                                            comments.cdt) && Objects.equals(
                udt, comments.udt) && Objects.equals(uid, comments.uid) && Objects.equals(cid,
                                                                                          comments.cid) && Objects.equals(
                userNo, comments.userNo);
      }

      @Override
      public int hashCode() {
            return Objects.hash(commentNo, commentNm, commentPw, commentContent, cdt, udt, uid, cid, userNo, articleNo);
      }

}
