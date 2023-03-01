package com.pce.timeplanner;


import com.pce.timeplanner.implementation.Temps;
import com.pce.timeplanner.implementation.Utilisateur;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@CrossOrigin
public class TestController {
    String test = "test";
    @GetMapping(value = "/test/{display}")
    String test(@PathVariable String display){
        return "test"+display;
    }
    @GetMapping(value = "/bonjour")
    String hello(@RequestParam(required = false) String prenom,
                @RequestParam(required = true) String nom)
    {
        return "Tu t'appelles "+prenom+" "+nom;
    }

    @PostMapping("/saisie")
    void insert(@RequestHeader("invocationFrom") String invocationFrom,
                @Valid @RequestBody Temps temps){
        log.info(temps.toString());
    }


    @PostMapping("/user")
    void insertUser(@RequestHeader("invocationFrom") String invocationFrom,
                @Valid @RequestBody Utilisateur utilisateur){
        log.info(utilisateur.toString());
        System.out.println(utilisateur.getEmail());
    }
}
