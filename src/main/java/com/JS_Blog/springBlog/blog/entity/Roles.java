package com.JS_Blog.springBlog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * packageName    : com.JS_Blog.springBlog.blog.entity
 * fileName       : Roles
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
public class Roles {

      @Basic
      @Id
      @Column(name = "user_no", insertable = false, updatable = false)
      private int userNo;

      @Basic
      @Column(name = "user_role")
      private String userRole;

      @ManyToOne
      @JoinColumn(name = "user_no", insertable = false, updatable = false, referencedColumnName = "user_no", nullable = false)
      private Users usersByUserNo;

      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            Roles roles = (Roles) o;
            return userNo == roles.userNo && Objects.equals(userRole, roles.userRole);
      }

      @Override
      public int hashCode() {
            return Objects.hash(userNo, userRole);
      }

}
