package com.pce.timeplanner.services;

import com.pce.timeplanner.implementation.JourTravail;
import com.pce.timeplanner.implementation.Utilisateur;
import lombok.extern.slf4j.Slf4j;

@Slf4j
/*//@Component*/
public class SaisieService {
    /*private Logger logger = Logger.getLogger(SaisieService.class.getName());*/

    public static String saisieTemps(Utilisateur utilisateur, JourTravail jourTravail, double duree){
        jourTravail.setTempsRealise(jourTravail.getTempsRealise()+duree);
        log.info("Duree :"+duree);
        return "test";
    }

}
