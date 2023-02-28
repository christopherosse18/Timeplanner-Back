package com.pce.timeplanner.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration

@EnableAspectJAutoProxy
public class ProjectConfig {
   /* @Bean
    Utilisateur user(){
        Utilisateur user = new Utilisateur();
        user.setNom("Rossé");
        user.setPrenom("Alexandra");
        user.setUsername("arosse");
        user.setService(service());
        return user;
    }

    @Bean
    Service service(){
        var service = new Service();
        var jours = new ArrayList<Jours>();
        jours.add(Jours.mercredi);
        jours.add(Jours.jeudi);
        jours.add(Jours.vendredi);
        service.setNom("Customer Services");
        service.setJoursActifs(jours);
        service.setTauxActivite(0.5);
        service.setHeures(8);
        return service;
    }

    @Bean
    JourTravail jourTravail(){
        var jour = new JourTravail();
        jour.setJours(Jours.mercredi);
        jour.setDuree(8.0);
        jour.setTempsRealise(0);
        return jour;
    }

    @Bean
    SaisieService saisieService(){
        return new SaisieService();
    }*/
}
