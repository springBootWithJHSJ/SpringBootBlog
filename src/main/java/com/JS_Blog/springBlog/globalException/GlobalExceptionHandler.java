package com.JS_Blog.springBlog.globalException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * packageName    : com.JS_Blog.springBlog.globalException
 * fileName       : GlobalExceptionHandler
 * author         : ipeac
 * date           : 2022-05-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-06        ipeac       최초 생성
 */
@RestControllerAdvice
/*@RestControllerAdvice :  @ControllerAdvice에 @ResponseBody가 적용된 형태

스프링은 예외 처리를 위해 @ControllerAdvice와 @ExceptionHandler 등의 기능을 지원해 주는데요.

@ControllerAdvice : 컨트롤러 전역에서 발생 할 수 있는 예외를 Throw
@ExceptionHandler : 특정 클래스에서 발생할 수 있는 예외를 잡아 Throw
*/
@Slf4j
public class GlobalExceptionHandler {

      @ExceptionHandler(RuntimeException.class)
      public String handleRuntimeException(final RuntimeException e) {
            log.error("handleRuntimeException() is invoked : {}", e.getMessage());
            return e.getMessage();
      }

}
