package com.web.web_spingboot.common;

/**
 * 业务异常，前端可以将这类异常信息原样显示给用户
 */
public class BizException extends RuntimeException{
    public BizException(String errorMsg) {
        super(errorMsg);
    }
}
