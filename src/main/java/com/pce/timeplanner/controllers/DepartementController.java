package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.ContratJour;
import com.pce.timeplanner.implementation.Departement;
import com.pce.timeplanner.implementation.Jours;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.DepartementRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping(path = "/departement")
@CrossOrigin(origins="*")
public class DepartementController {
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/getDepartementById")
    public Departement getDepartementById(@RequestParam int id) {
        return departementRepository.findByIdDepartement(id);
    }

    @GetMapping("/getAllDepartements")
    public List<Departement> getAllDepartements(){
        return departementRepository.findAll();
    }

    @PostMapping("/createNewDepartement")
    @Transactional
    public void createNewDepartement(@RequestParam String username,
                                   @RequestParam List<String> jours,
                                   @RequestParam List<Double> durees,
                                   @RequestParam List<Boolean> conge,
                                   @RequestParam String nom){
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);

        Departement departement = new Departement();
        departement.setIdDepartement(UUID.randomUUID());
        departement.setNom(nom);
        //Création d'une map pour la journée
        List<ContratJour> contratJours = new ArrayList<>();
        for (int i = 0; i < jours.size(); i++) {
            ContratJour contratJour = new ContratJour();
            contratJour.setIdContratJour(UUID.randomUUID());
            contratJour.setJour(jours.get(i));
            contratJour.setDuree(durees.get(i));
            contratJour.setConge(conge.get(i));
            contratJours.add(contratJour);
        }
        departement.setContratJours(contratJours);
        departement.setUtilisateur(utilisateur);
        departementRepository.save(departement);
    }

}
