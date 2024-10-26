package com.example.ticketing.ticket;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketCreator {

    private int ticketCount = 100;

    public synchronized String getTicketCode() {
        ticketCount--;
        if (ticketCount < 0) {
            throw new RuntimeException("티켓이 모두 소진되었습니다.");
        }
        return UUID.randomUUID().toString().substring(0, 10);
    }

    public void resetCount() {
        ticketCount = 100;
    }
}
