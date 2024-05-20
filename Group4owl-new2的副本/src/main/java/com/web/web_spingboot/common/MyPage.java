package com.web.web_spingboot.common;

import lombok.Data;

/**
 * 接口统一返回数据模型
 */
@Data
public class MyPage<T> {
    private Integer total;
    private T list;
}
