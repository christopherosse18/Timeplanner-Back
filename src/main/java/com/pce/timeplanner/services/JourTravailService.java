package com.pce.timeplanner.services;

import com.pce.timeplanner.implementation.JourTravail;
import com.pce.timeplanner.implementation.Saisie;
import com.pce.timeplanner.implementation.Utilisateur;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class JourTravailService {
    static public Set<JourTravail> createSevenDaysFromDate(LocalDate localDate, Utilisateur utilisateur){
        Set<JourTravail> jourTravails = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            JourTravail jourTravail = new JourTravail();
            Set<Saisie> saisies = new HashSet<>();
            jourTravail.setIdJourTravail(UUID.randomUUID());
            jourTravail.setTempsRealise(0);
            jourTravail.setDate(localDate.plusDays(i));
            jourTravail.setSaisies(saisies);
            jourTravail.setDuree(UtilisateurService.getDureeByDay(localDate.plusDays(i), utilisateur));
            jourTravails.add(jourTravail);
        }
        return jourTravails;
    }

}
