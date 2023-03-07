package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.JourTravail;
import com.pce.timeplanner.implementation.Saisie;
import com.pce.timeplanner.implementation.TypeSaisie;
import com.pce.timeplanner.repository.JourTravailRepository;
import com.pce.timeplanner.repository.SaisieRepository;
import com.pce.timeplanner.repository.SemaineTravailRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(path = "/semaine")
@CrossOrigin(origins="*")
public class JourTravailController {
    @Autowired
    JourTravailRepository jourTravailRepository;
    @Autowired
    SaisieRepository saisieRepository;

    @PostMapping(path = "/{username}/{semaine}/addSaisie")
    public Saisie addSaisie(@PathVariable("username") String username,
                          @PathVariable("semaine") int semaine,
                          @RequestParam String idJour,
                          @RequestParam TypeSaisie typeSaisie,
                          @RequestParam LocalTime debut,
                          @RequestParam LocalTime fin,
                          @RequestParam(required = false) String idSaisie
                          /*@RequestBody Saisie saisieFront*/){
        JourTravail jourTravail = jourTravailRepository.getJourTravailByIdJourTravail(UUID.fromString(idJour));
        Saisie saisie = new Saisie();
        /**Création de la saisie **/
        if (idSaisie == null || idSaisie.equals("")){
            saisie.setIdSaisie(UUID.randomUUID());
            saisie.setTypeSaisie(typeSaisie);
            saisie.setHeureDebut(debut);
            saisie.setHeureFin(fin);
            jourTravail.getSaisies().add(saisie);
        /**Update de la saisie **/
        } else {
            saisie = saisieRepository.findByIdSaisie(UUID.fromString(idSaisie));
            saisie.setTypeSaisie(typeSaisie);
            saisie.setHeureDebut(debut);
            saisie.setHeureFin(fin);
        }

        jourTravailRepository.save(jourTravail);

        return jourTravail.getSaisies().stream().toList().get(0);
    }

    @DeleteMapping(value="/{username}/{semaine}/deleteSaisie")
    public Map<String, String> deleteSaisie(@PathVariable("username") String username,
                                            @PathVariable("semaine") int semaine,
                                            @RequestParam String idSaisie) {
        saisieRepository.deleteById(UUID.fromString(idSaisie));
        HashMap<String, String> message = new HashMap<>();
        message.put("Message", "Entrée "+idSaisie+" supprimée");
        return message;
    }
}
