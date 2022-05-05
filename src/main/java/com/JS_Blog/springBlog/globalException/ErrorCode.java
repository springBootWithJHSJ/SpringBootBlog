package com.JS_Blog.springBlog.globalException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * packageName    : com.JS_Blog.springBlog.globalException
 * fileName       : ErrorCode
 * author         : ipeac
 * date           : 2022-05-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-06        ipeac       최초 생성
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
      /*
       *  400 BAD_REQUEST : 잘못된 요청
       * */
      BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다,"),

      /*
       * 404 NOT_FOUND: 리소스를 찾을 수 없음
       */
      POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없습니다."),

      /*
       * 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
       */
      METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),

      /*
       * 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
       */
      INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다."),
      ;

      private final HttpStatus status;
      private final String message;
}
/*
 * 전체적인 예외를 관리할 Enum 클스스
 * */
