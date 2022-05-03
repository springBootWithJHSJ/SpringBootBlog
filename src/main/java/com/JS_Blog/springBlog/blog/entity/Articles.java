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
      @Column(name = "article_no")
      private short articleNo;
      @Basic
      @Column(name = "article_content")
      private String articleContent;
      @Basic
      @Column(name = "article_show_yn")
      private String articleShowYn;
      @Basic
      @Column(name = "UDT")
      private Date udt;
      @Basic
      @Column(name = "CDT")
      private Date cdt;
      @Basic
      @Column(name = "CID")
      private String cid;
      @Basic
      @Column(name = "UID")
      private String uid;
      @Basic
      @Column(name = "thumbnail")
      private String thumbnail;
      @Basic
      @Column(name = "user_no")
      private short userNo;
      @Basic
      @Column(name = "category_no")
      private Short categoryNo;
      @ManyToOne
      @JoinColumn(name = "user_no", referencedColumnName = "user_no", nullable = false)
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


      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            Articles articles = (Articles) o;
            return articleNo == articles.articleNo && userNo == articles.userNo && Objects.equals(articleContent,
                                                                                                  articles.articleContent) && Objects.equals(
                articleShowYn, articles.articleShowYn) && Objects.equals(udt, articles.udt) && Objects.equals(cdt,
                                                                                                              articles.cdt) && Objects.equals(
                cid, articles.cid) && Objects.equals(uid, articles.uid) && Objects.equals(thumbnail,
                                                                                          articles.thumbnail) && Objects.equals(
                categoryNo, articles.categoryNo);
      }

      @Override
      public int hashCode() {
            return Objects.hash(articleNo, articleContent, articleShowYn, udt, cdt, cid, uid, thumbnail, userNo,
                                categoryNo);
      }

      public Users getUsersByUserNo() {
            return usersByUserNo;
      }

      public void setUsersByUserNo(Users usersByUserNo) {
            this.usersByUserNo = usersByUserNo;
      }

      public Category getCategoryByCategoryNo() {
            return categoryByCategoryNo;
      }

      public void setCategoryByCategoryNo(Category categoryByCategoryNo) {
            this.categoryByCategoryNo = categoryByCategoryNo;
      }

      public Collection<ArticlesTags> getArticlesTagsByArticleNo() {
            return articlesTagsByArticleNo;
      }

      public void setArticlesTagsByArticleNo(Collection<ArticlesTags> articlesTagsByArticleNo) {
            this.articlesTagsByArticleNo = articlesTagsByArticleNo;
      }

      public Collection<Comments> getCommentsByArticleNo() {
            return commentsByArticleNo;
      }

      public void setCommentsByArticleNo(Collection<Comments> commentsByArticleNo) {
            this.commentsByArticleNo = commentsByArticleNo;
      }

      public Collection<Likes> getLikesByArticleNo() {
            return likesByArticleNo;
      }

      public void setLikesByArticleNo(Collection<Likes> likesByArticleNo) {
            this.likesByArticleNo = likesByArticleNo;
      }

}
