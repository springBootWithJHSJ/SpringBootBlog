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
 * fileName       : Users
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
public class Users {

      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Id
      @Column(name = "user_no", nullable = false)
      private int userNo;

      @Basic
      @Column(name = "user_name")
      private String userName;

      @Basic
      @Column(name = "user_email")
      private String userEmail;
      @Basic
      @Column(name = "user_password")
      private String userPassword;
      @Basic
      @Column(name = "user_role")
      private String userRole;

      @OneToMany(mappedBy = "usersByUserNo")
      private Collection<Articles> articlesByUserNo;

      @OneToMany(mappedBy = "usersByUserNo")
      private Collection<Category> categoriesByUserNo;

      @OneToMany(mappedBy = "usersByUserNo")
      private Collection<Comments> commentsByUserNo;

      @OneToMany(mappedBy = "usersByUserNo")
      private Collection<Likes> likesByUserNo;

      @OneToMany(mappedBy = "usersByUserNo")
      private Collection<Roles> rolesByUserNo;

      @Override
      public boolean equals(Object o) {
            if (this == o) {
                  return true;
            }
            if (o == null || getClass() != o.getClass()) {
                  return false;
            }
            Users users = (Users) o;
            return userNo == users.userNo && Objects.equals(userName, users.userName) && Objects.equals(userEmail,
                                                                                                        users.userEmail) && Objects.equals(
                userPassword, users.userPassword) && Objects.equals(userRole, users.userRole);
      }

      @Override
      public int hashCode() {
            return Objects.hash(userNo, userName, userEmail, userPassword, userRole);
      }

}
