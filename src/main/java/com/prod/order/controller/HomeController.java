package com.prod.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "/page/home";
    }
}
