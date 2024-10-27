package com.example.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/chat"))
public class ChatController {
    @GetMapping("/enter")
    public String enterChatRoom(){
        return "enter";
    }

    @PostMapping("/send")
    public String sendChat(){
        return "sendChat";
    }
}
