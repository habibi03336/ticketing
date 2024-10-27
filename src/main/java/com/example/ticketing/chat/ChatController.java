package com.example.ticketing.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/chat")
public class ChatController {


    @GetMapping(value = "/enter", produces = "text/event-stream")
    public Flux<String> enterChatRoom(){
        return Flux.interval(Duration.ofSeconds(1)) // 1초 간격으로 이벤트 생성
                .map(seq -> "Event " + seq);
    }

    @PostMapping("/send")
    public String sendChat(){
        return "sendChat";
    }
}
