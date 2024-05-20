package com.web.web_spingboot.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebRTCController {

    @MessageMapping("/signal")
    @SendTo("/topic/signal")
    public String handleSignal(String signal) {
        return signal;
    }




}
