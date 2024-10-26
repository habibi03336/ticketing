package com.example.ticketing.ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RedisHash(value = "Ticket")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket implements Serializable {

    @Id
    private String id;

    private String code;

    private LocalDateTime createdAt;

    public Ticket(String id, String code) {
        this.id = id;
        this.code = code;
        this.createdAt = LocalDateTime.now();
    }
}
