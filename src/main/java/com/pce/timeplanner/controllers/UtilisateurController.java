package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.Departement;
import com.pce.timeplanner.implementation.Jours;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.DepartementRepository;
import com.pce.timeplanner.repository.UtilisateurRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
    private EntityManager entityManager;
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
