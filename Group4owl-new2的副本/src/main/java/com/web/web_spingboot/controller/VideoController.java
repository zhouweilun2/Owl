package com.web.web_spingboot.controller;

import com.web.web_spingboot.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class VideoController {

    private final SimpMessagingTemplate stompTemplate;
    private final List<String> users = new CopyOnWriteArrayList<>();

    public VideoController(SimpMessagingTemplate stompTemplate) {
        this.stompTemplate = stompTemplate;
    }

    @MessageMapping("/video")
    public void handleVideoData(byte[] videoData) {
        stompTemplate.convertAndSend("/topic/video", videoData);
    }

//    @MessageMapping("/join")
//    public void joinConference(String username) {
//        users.add(username);
//        stompTemplate.convertAndSend("/topic/users", users);
//    }

    @MessageMapping("/chat") // 处理聊天消息
    public void handleChatMessage(@Payload ChatMessage chatMessage) {
        stompTemplate.convertAndSend("/topic/chat", chatMessage);
    }

//    @MessageMapping("/leave")
//    public void leaveConference(String username) {
//        users.remove(username);
//        stompTemplate.convertAndSend("/topic/users", users);
//    }

    @MessageMapping("/join")
    public void joinConference(String username) {
        users.add(username);
        stompTemplate.convertAndSend("/topic/users", users);

        // 发送加入会议的通知消息
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        chatMessage.setSender(username);
        chatMessage.setContent("joined the conference");
        stompTemplate.convertAndSend("/topic/chat", chatMessage);
    }

    @MessageMapping("/leave")
    public void leaveConference(String username) {
        users.remove(username);
        stompTemplate.convertAndSend("/topic/users", users);

        // 发送离开会议的通知消息
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.LEAVE);
        chatMessage.setSender(username);
        chatMessage.setContent("left the conference");
        stompTemplate.convertAndSend("/topic/chat", chatMessage);
    }




}
