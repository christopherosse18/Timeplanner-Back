package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.JourTravail;
import com.pce.timeplanner.implementation.SemaineTravail;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.SemaineTravailRepository;
import com.pce.timeplanner.repository.TempsRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import com.pce.timeplanner.services.JourTravailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.HashSet;
import java.util.Locale;
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
    @GetMapping("/weekExist")
    public SemaineTravail weekExist(@RequestParam String username,
                                    @RequestParam String date){
        LocalDate localDate = LocalDate.parse(date);
        int semaineNb = localDate.get(WeekFields.of(Locale.FRANCE).weekOfYear());
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        SemaineTravail semaineTravail = semaineTravailRepository
                .findSemaineTravailByNumSemaineAndTemps(semaineNb, utilisateur.getTemps());
        if (semaineTravail==null){
            LocalDate premierJourSem = localDate.with(DayOfWeek.MONDAY);
            semaineTravail = createEmptySemaine(username, premierJourSem, semaineNb);
        }
        return semaineTravail;
    }
    @PostMapping("/createEmptySemaine")
    public SemaineTravail createEmptySemaine(@RequestParam String username,
                                   @RequestParam LocalDate localDate,
                                   @RequestParam(required = false) int numSemaine){
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        SemaineTravail semaineTravail = new SemaineTravail();
        semaineTravail.setIdSemaineTravail(UUID.randomUUID());
        if (numSemaine == 0){
            semaineTravail.setNumSemaine(SemaineTravail.getCurrentWeek());
        } else {
            semaineTravail.setNumSemaine(numSemaine);
        }
        //Créé 7 jours
        Set<JourTravail> jours = JourTravailService
                .createSevenDaysFromDate(localDate, utilisateur);
        semaineTravail.setJoursTravail(jours);
        semaineTravail.setHeuresRealisees(0);
        semaineTravail.setHeuresDues(40);
        utilisateur.getTemps().getSemaineTravail().add(semaineTravail);
        tempsRepository.save(utilisateur.getTemps());
        //Faire fonction pour récupérer le nombre d'heures du contrat
        return semaineTravail;
    }
    //@PostMapping("/createEmptyJour")
}
