package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.Departement;
import com.pce.timeplanner.implementation.Jours;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.DepartementRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public void createEmptyService(@RequestParam String username,
                                   @RequestParam List<Jours> jours,
                                   @RequestParam double heures,
                                   @RequestParam double tauxActivite,
                                   @RequestParam String nom){
        /*List<Departement> services = new ArrayList<>();*/

        /*utilisateurs.add(utilisateurRepository.findByUsername(username));
        System.out.println(utilisateurs);*/
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);

        Departement departement = new Departement(UUID.randomUUID(),
                nom, tauxActivite, heures, jours);
        departement.setUtilisateur(utilisateur);
        departementRepository.save(departement);

        /*utilisateurRepository.persist(newUser);*/
       /* entityManager.persist(saveUser);
        utilisateurRepository.findByUsername(username).setDepartement();
        utilisateurRepository.*/
    }

}
