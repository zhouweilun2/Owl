package com.web.web_spingboot.controller;

import com.web.web_spingboot.common.CheckLogin;
import com.web.web_spingboot.common.MyPage;
import com.web.web_spingboot.common.Rs;
import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.service.MessageService;
import com.web.web_spingboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 消息接口
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getEnergy")
    public ResponseEntity<Integer> getUserEnergy(Integer userId) {
        try {
            // Fetch the user's energy value from the service
            Integer energy = userService.getUserEnergy(userId);
            // Return the energy value with a success status code
            return ResponseEntity.ok(energy);
        } catch (Exception e) {
            // Return an error response if there's an exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
