package com.example.ticketing.ticket;

import com.example.ticketing.ticket.dto.TicketRankDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;


@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketCreator ticketCreator;

    private final TicketTimer ticketTimer;

    private final TicketRepository ticketRepository;

    public void initSetting() {
        ticketTimer.resetStartTime();
        ticketCreator.resetCount();
        LocalDateTime startTime = ticketTimer.getStartTime();
        log.info("[ Server Log ] : 변경된 티켓 예매 시작 시간 = {}", startTime);
    }

    public void deleteAllRecord() {
        ticketRepository.deleteAll();
    }

    public void issueTicket(String name) {
        if (!ticketTimer.isValidStartTime()) {
            throw new RuntimeException("티켓팅 시작 시간이 아닙니다.");
        }
        String ticketCode = ticketCreator.getTicketCode();
        Ticket ticket = new Ticket(name, ticketCode);
        ticketRepository.save(ticket);
    }

    public List<TicketRankDto> getRankInfo() {
        Iterable<Ticket> tickets = ticketRepository.findAll();
        return StreamSupport
                .stream(tickets.spliterator(), false)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Ticket::getCreatedAt))
                .map(TicketRankDto::createFromTicket).toList();
    }
}
