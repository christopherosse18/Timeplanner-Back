package com.pce.timeplanner.services;

import com.pce.timeplanner.implementation.ContratJour;
import com.pce.timeplanner.implementation.Utilisateur;
import com.pce.timeplanner.repository.ContratJourRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

public class UtilisateurService {
    static ContratJourRepository contratJourRepository;

    static public Double getDureeByDay(LocalDate localDate, Utilisateur utilisateur){
        String day = localDate.format(DateTimeFormatter.ofPattern("EEEE", Locale.FRENCH));
        //ContratJour contratJour = contratJourRepository.findFirstByJourContaining(day);
        Double sum = utilisateur.getDepartements().stream()
                .flatMap(dep -> dep.getContratJours().stream())
                .filter(con -> con.getJour().equals(day))
                .mapToDouble(ContratJour::getDuree)
                .sum();
        return sum;
        /*if (sum == null ){
            return 0.0;
        } else {
            return contratJour.getDuree();
        }*/
    }
}
