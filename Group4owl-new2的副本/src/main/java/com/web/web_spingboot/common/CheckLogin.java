package com.web.web_spingboot.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CheckLogin {
    public static void check(Integer userId){
        if(userId == null){
            throw new BizException("没登录");
        }
    }
}
