package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins="*")
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @GetMapping("/getAllUsersByName")
    public List<Utilisateur> getAllUsersByName(@RequestParam String name){
        return utilisateurRepository.findAllByNom(name);
    }
    @GetMapping("/getAllUsers")
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }
    @GetMapping("/getUserById")
    public Optional<Utilisateur> getUtilisateur(@RequestParam int id){
        return utilisateurRepository.findById(id);
    }

}
