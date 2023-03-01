package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Person {
    String nom;
    String prenom;
    String username;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
