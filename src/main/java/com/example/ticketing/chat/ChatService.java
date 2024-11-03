package com.example.ticketing.chat;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class ChatService {
    Sinks.Many<ChatVO> channel = Sinks.many().multicast().directAllOrNothing();

    public Flux<ServerSentEvent<ChatVO>> connect() {
        return channel.asFlux().map((c) -> ServerSentEvent.builder(c).build()).doOnCancel(()->{
            channel.asFlux().blockLast(); // 이 doOnCancel을 추가하지 않으면 에러가 발생한다. why?
        });
    }

    public void addChat(ChatVO chat){
        channel.tryEmitNext(chat);
    }
}
