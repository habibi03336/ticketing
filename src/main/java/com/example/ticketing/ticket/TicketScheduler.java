package com.example.ticketing.ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class TicketScheduler {

    private final TicketService ticketService;

    private final static int AI_USER_NUMBER = 50;

    private final static int AI_USER_INTERVAL = 100;

    @Scheduled(cron = "30 * * * * *")
    public void resetTime() {
        ticketService.initSetting();
    }

    @Scheduled(cron = "59 * * * * *")
    public void clearAllRecord() {
        ticketService.deleteAllRecord();
    }

    @Scheduled(cron = "0 * * * * *")
    public void activateAiUser() {
        String name = "AI-User-";
        for (int i=1; i<=AI_USER_NUMBER; i++) {
            try {
                Thread.sleep(AI_USER_INTERVAL);
                ticketService.issueTicket(name + i);
            } catch (Exception ignored) {}
        }
    }
}
