package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.JourTravail;
import com.pce.timeplanner.implementation.SemaineTravail;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.SemaineTravailRepository;
import com.pce.timeplanner.repository.TempsRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/temps")
@CrossOrigin(origins="*")
public class TempsController {
    @Autowired
    SemaineTravailRepository semaineTravailRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    TempsRepository tempsRepository;
    @PostMapping("/createEmptySemaine")
    public void createEmptySemaine(@RequestParam String username){
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        SemaineTravail semaineTravail = new SemaineTravail();
        semaineTravail.setIdSemaineTravail(UUID.randomUUID());
        semaineTravail.setNumSemaine(SemaineTravail.getCurrentWeek());
        Set<JourTravail> jours = new HashSet<>();
        semaineTravail.setJoursTravail(jours);
        semaineTravail.setHeuresRealisees(0);
        semaineTravail.setHeuresDues(40);
        utilisateur.getTemps().getSemaineTravail().add(semaineTravail);
        tempsRepository.save(utilisateur.getTemps());
        //Faire fonction pour récupérer le nombre d'heures du contrat

    }
    //@PostMapping("/createEmptyJour")
}
