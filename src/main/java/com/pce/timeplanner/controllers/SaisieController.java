package com.pce.timeplanner.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@Slf4j
@RequestMapping("/saisie")
public class SaisieController {
    @PostMapping("/addtemps")
    double addDailyTime(){
        return 0;
    }
}
