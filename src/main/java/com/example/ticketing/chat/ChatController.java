package com.example.ticketing.chat;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService cs;

    public ChatController(ChatService cs) {
        this.cs = cs;
    }

    @GetMapping(value = "/enter", produces = "text/event-stream")
    public Flux<ServerSentEvent<ChatVO>> enterChatRoom(){
        return cs.connect();
    }

    @PostMapping("/send")
    public void sendChat(@RequestBody ChatVO chat){
        cs.addChat(chat);
    }

}
