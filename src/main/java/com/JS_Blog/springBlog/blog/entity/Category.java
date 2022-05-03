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
 * fileName       : Category
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
public class Category {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "category_no")
      private short categoryNo;
      @Basic
      @Column(name = "category_name")
      private String categoryName;
      @Basic
      @Column(name = "user_no")
      private short userNo;
      @OneToMany(mappedBy = "categoryByCategoryNo")
      private Collection<Articles> articlesByCategoryNo;
      @ManyToOne
      @JoinColumn(name = "user_no", referencedColumnName = "user_no", nullable = false)
      private Users usersByUserNo;


      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            Category category = (Category) o;
            return categoryNo == category.categoryNo && userNo == category.userNo && Objects.equals(categoryName,
                                                                                                    category.categoryName);
      }

      @Override
      public int hashCode() {
            return Objects.hash(categoryNo, categoryName, userNo);
      }

}
