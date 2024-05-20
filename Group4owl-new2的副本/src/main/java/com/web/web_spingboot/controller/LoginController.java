package com.web.web_spingboot.controller;

import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 登录页面逻辑
 * by xx 24/03
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    //登录
   @PostMapping("/login")
    public User login(@RequestBody User user){
       User login = userService.login(user.getUser_number(), user.getPasswords());
       return login;
   }
    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return user;
    }
    @GetMapping("/getuser/current")
    public ResponseEntity<?> getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId"); // Assuming you store the user ID as "userId" in the session
        if(userId == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in.");
        }
        User user = userService.getUserById(userId);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.ok(user); // Or just the user ID if you prefer: return ResponseEntity.ok(userId);
    }



}
