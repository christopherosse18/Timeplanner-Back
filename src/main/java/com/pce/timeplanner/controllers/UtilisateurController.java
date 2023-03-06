package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.Temps;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.TempsRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import jakarta.persistence.EntityManager;
import jdk.jshell.execution.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/utilisateur")
@CrossOrigin(origins="*")
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    TempsRepository tempsRepository;
    @Autowired
    private EntityManager entityManager;
    @GetMapping("/getAllUsersByName")
    public List<Utilisateur> getAllUsersByName(@RequestParam String name){
        return utilisateurRepository.findAllByNom(name);
    }
    @CrossOrigin
    @PostMapping("/userExist")
    public Utilisateur userExist(@RequestParam String username){
        /*if (utilisateurRepository.findByUsername(username) != null){
            return "YAY !";
        } else {
            return "NEIGGGHHHH";
        }*/
        return utilisateurRepository.findByUsername(username);
    }
    @GetMapping("/getAllUsers")
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }
    @GetMapping("/getUserById")
    public Optional<Utilisateur> getUtilisateur(@RequestParam int id){
        return utilisateurRepository.findById(id);
    }

    @GetMapping("/existTemps")
    public Utilisateur createNewTemps(@RequestParam String username){
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur.getTemps() == null){
            Temps temps = new Temps();
            temps.setUtilisateur(utilisateur);
            temps.setIdTemps(UUID.randomUUID());
            utilisateur.setTemps(temps);
            utilisateurRepository.save(utilisateur);
        }
        return utilisateur;
    }



}
