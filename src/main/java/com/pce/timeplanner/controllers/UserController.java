package com.pce.timeplanner.controllers;

import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/getAllUsersByName")
    public List<Utilisateur> getAllUsersByName(@RequestParam String name){
        return userRepository.findAllByNom(name);
    }

}
