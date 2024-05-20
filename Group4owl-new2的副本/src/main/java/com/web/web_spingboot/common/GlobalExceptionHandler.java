package com.web.web_spingboot.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 **/
@Slf4j
@RestControllerAdvice
@Order
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Rs<Object> handle(Exception e) throws Exception {
        log.error("[ 系统未知错误 ]", e);
        return Rs.fail("系统未知错误");
    }

    @ExceptionHandler(value = BizException.class)
    public Rs<Object> handle(BizException e) {
        log.error("[ 业务异常 ]", e);
        return Rs.fail(e.getMessage());
    }
}
