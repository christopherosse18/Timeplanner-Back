package com.pce.timeplanner.controllers;

import com.pce.timeplanner.repository.SemaineTravailRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/semaineTravail")
@CrossOrigin(origins="*")
public class SemaineTravailController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    SemaineTravailRepository semaineTravailRepository;
}
