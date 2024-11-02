package com.example.ticketing.chat;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class ChatService {
    Sinks.Many<ChatVO> channel = Sinks.many().multicast().directAllOrNothing();

    public Flux<ServerSentEvent<ChatVO>> connect() {
        return channel.asFlux().map((c) -> ServerSentEvent.builder(c).build());
    }

    public void addChat(ChatVO chat){
        channel.tryEmitNext(chat);
    }
}
