package com.example.ticketing.chat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "Chat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {
    @Id
    private String id;

    private String name;

    private String text;

    private LocalDateTime createdAt;

    public Chat(String name, String text) {
        LocalDateTime now = LocalDateTime.now();;
        this.id = name + text + now;
        this.name = name;
        this.text = text;
        this.createdAt = now;
    }
}
