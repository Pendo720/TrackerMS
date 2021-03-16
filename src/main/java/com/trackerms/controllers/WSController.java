package com.trackerms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WSController {

    private final SimpMessagingTemplate _template;

    @Autowired
    public WSController(SimpMessagingTemplate _template) {
        this._template = _template;
    }

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public String sendMessage(String message) {
        System.out.println(message);
        this._template.convertAndSend("/message", message);
        return "WS says: " + message;
    }
}
