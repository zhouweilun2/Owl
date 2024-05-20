package com.web.web_spingboot.common;

import lombok.Data;

/**
 * 接口统一返回数据模型
 */
@Data
public class Rs<T> {
    private Boolean ok;
    private T data;
    private String msg;
    /**
     * 暂时用到一个 noLogin
     */
    private String code;

    public Rs(Boolean ok, T data, String msg, String code){
        this.ok = ok;
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    /**
     * 成功，不用返回数据
     */
    public static <T> Rs<T> ok() {
        return new Rs<>(true, null, null, null);
    }

    /**
     * 成功，返回数据
     */
    public static <T> Rs<T> ok(T data) {
        return new Rs<>(true, data, null, null);
    }

    /**
     * 失败，前端显示失败原因msg
     */
    public static <T> Rs<T> fail(String msg) {
        return new Rs<>(false, null, msg, null);
    }

    /**
     * 返回错误码
     */
    public static <T> Rs<T> failCode(String code) {
        return new Rs<>(false, null, null, code);
    }
}
