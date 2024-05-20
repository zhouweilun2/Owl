package com.web.web_spingboot.controller;

import com.web.web_spingboot.common.CheckLogin;
import com.web.web_spingboot.common.MyPage;
import com.web.web_spingboot.common.Rs;
import com.web.web_spingboot.entity.Message;
import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.service.MessageService;
import com.web.web_spingboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 消息接口
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/getMessages")
    public Rs<MyPage<List<Message>>> getMessages(Integer userId, Integer current, Integer size){
        CheckLogin.check(userId);
        MyPage<List<Message>> messages = messageService.getMessages(userId, current, size);
        return Rs.ok(messages);
    }

    @GetMapping("/getMessageById")
    public Rs<Message> getMessageById(Integer id){
        Message message = messageService.getMessageById(id);
        return Rs.ok(message);
    }

    @PostMapping("/createMessage")
    public Rs<Void> createMessage(@RequestBody Message message){
        CheckLogin.check(message.getSenderId());
        messageService.createMessage(message);
        return Rs.ok();
    }
}
