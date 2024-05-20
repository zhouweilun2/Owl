package com.web.web_spingboot.controller;

import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 注册页面逻辑
 * by xx 24/03
 */
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Boolean insterUser(@RequestBody User user){
        user.setUser_type("员工");
        Boolean register = userService.register(user);
        System.out.print("registest");
        return register;
    }
}
