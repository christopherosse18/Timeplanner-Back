package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.SemaineTravail;
import com.pce.timeplanner.implementation.Temps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SemaineTravailRepository extends JpaRepository<SemaineTravail, Integer> {
    SemaineTravail findSemaineTravailByNumSemaineAndTemps(int numSemaine, Temps temps);
    
}
