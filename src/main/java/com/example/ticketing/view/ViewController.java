package com.example.ticketing.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ViewController {

    @GetMapping("/")
    public String main() {
        log.info("[ Server Log ] : 홈페이지 접근");
        return "main";
    }

    @GetMapping("/rank")
    public String RankPage() {
        log.info("[ Server Log ] : 순위 페이지 접근");
        return "rank";
    }
}
