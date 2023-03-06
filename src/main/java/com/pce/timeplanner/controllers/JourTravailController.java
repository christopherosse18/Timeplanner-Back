package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.JourTravail;
import com.pce.timeplanner.implementation.Saisie;
import com.pce.timeplanner.implementation.TypeSaisie;
import com.pce.timeplanner.repository.JourTravailRepository;
import com.pce.timeplanner.repository.SemaineTravailRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/semaine")
@CrossOrigin(origins="*")
public class JourTravailController {
    @Autowired
    JourTravailRepository jourTravailRepository;

    @PostMapping(path = "/{username}/{semaine}/addSaisie")
    public UUID addSaisie(@PathVariable("username") String username,
                          @PathVariable("semaine") int semaine,
                          @RequestParam String idJour,
                          /*@RequestParam TypeSaisie typeSaisie,
                          @RequestParam(required = false) LocalTime debut,
                          @RequestParam(required = false) boolean debutNow,
                          @RequestParam(required = false) LocalTime fin,
                          @RequestParam(required = false) boolean finNow*/
                          @RequestParam Saisie saisieFront){

        JourTravail jourTravail = jourTravailRepository.getJourTravailByIdJourTravail(UUID.fromString(idJour));
        Saisie saisie = new Saisie();
        saisie.setIdSaisie(UUID.randomUUID());
        saisie.setTypeSaisie(saisieFront.getTypeSaisie());
       /* if (debutNow){
            saisie.setHeureDebut(LocalTime.now());
        } else {
            saisie.setHeureDebut(debut);
        }
        if (finNow){
            saisie.setHeureFin(LocalTime.now());
        } else {
            saisie.setHeureFin(fin);
        }*/
        saisie.setHeureDebut(saisieFront.getHeureDebut());
        saisie.setHeureFin(saisieFront.getHeureFin());
        jourTravail.getSaisies().add(saisie);
        jourTravailRepository.save(jourTravail);
        return saisie.getIdSaisie();
    }
}
