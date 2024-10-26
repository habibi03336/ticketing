package com.example.ticketing.ticket;

import com.example.ticketing.ticket.dto.TicketRankDto;
import com.example.ticketing.ticket.dto.TicketRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/rank")
    public ResponseEntity<?> getRankInfo() {
        List<TicketRankDto> rankInfo = ticketService.getRankInfo();
        return ResponseEntity.ok(rankInfo);
    }

    @PostMapping("/ticket")
    public ResponseEntity<?> registerTicket(@RequestBody TicketRequestDto dto) {
        log.info("[ Server Log ] : Ticketing is start");
        log.info("[ Request Nickname ] : {}", dto.getName());
        ticketService.issueTicket(dto.getName());
        return ResponseEntity.ok().build();
    }
}
