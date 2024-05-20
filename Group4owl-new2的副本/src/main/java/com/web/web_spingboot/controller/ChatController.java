////package com.web.web_spingboot.controller;
////
////import com.web.web_spingboot.entity.ChatMessage;
////import org.springframework.messaging.handler.annotation.MessageMapping;
////import org.springframework.messaging.handler.annotation.Payload;
////import org.springframework.messaging.handler.annotation.SendTo;
////import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
////import org.springframework.stereotype.Controller;
////@Controller
////public class ChatController {
////    @MessageMapping("/chat.sendMessage")
////    @SendTo("/topic/public")
////    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
////        return chatMessage;
////    }
////    @MessageMapping("/chat.addUser")
////    @SendTo("/topic/public")
////    public ChatMessage addUser(@Payload ChatMessage chatMessage,
////                               SimpMessageHeaderAccessor headerAccessor) {
////        // Add username in web socket session
////        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
////        return chatMessage;
////    }
////}
//
//package com.web.web_spingboot.controller;
//
//import com.web.web_spingboot.entity.ChatMessage;
//import com.web.web_spingboot.entity.ChatMessage.MessageType;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class ChatController {
//
//    private final SimpMessagingTemplate messagingTemplate;
//    private final List<String> participants = new ArrayList<>();
//
//    public ChatController(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    @MessageMapping("/chat")
//    @SendTo("/topic/chat")
//    public ChatMessage send(ChatMessage chatMessage) {
//        return chatMessage;
//    }
//
//    @MessageMapping("/join")
//    public void join(String username) {
//        if (!participants.contains(username)) {
//            participants.add(username);
//            ChatMessage joinMessage = new ChatMessage();
//            joinMessage.setType(MessageType.JOIN);
//            joinMessage.setSender(username);
//            joinMessage.setContent(username + " joined the conference");
//            messagingTemplate.convertAndSend("/topic/chat", joinMessage);
//            messagingTemplate.convertAndSend("/topic/users", participants);
//        }
//    }
//
//    @MessageMapping("/leave")
//    public void leave(String username) {
//        if (participants.contains(username)) {
//            participants.remove(username);
//            ChatMessage leaveMessage = new ChatMessage();
//            leaveMessage.setType(MessageType.LEAVE);
//            leaveMessage.setSender(username);
//            leaveMessage.setContent(username + " left the conference");
//            messagingTemplate.convertAndSend("/topic/chat", leaveMessage);
//            messagingTemplate.convertAndSend("/topic/users", participants);
//        }
//    }
//}
