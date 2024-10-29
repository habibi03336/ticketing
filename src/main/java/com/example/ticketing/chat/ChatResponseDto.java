package com.example.ticketing.chat;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ChatResponseDto {
    private String name;
    private String text;
    private String sendAt;

    public static ChatResponseDto createFromChat(String name, String text, LocalDateTime sendAt) {
        ChatResponseDto dto = new ChatResponseDto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String sendAtString = sendAt.format(formatter);
        dto.name = name;
        dto.text = text;
        dto.sendAt = sendAtString;
        return dto;
    }
}
