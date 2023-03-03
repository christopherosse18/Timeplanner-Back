package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.ContratJour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratJourRepository extends JpaRepository<ContratJour, Integer> {
    ContratJour findFirstByJourContaining(String jour);
}
