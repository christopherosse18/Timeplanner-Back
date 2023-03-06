package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.Saisie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaisieRepository extends JpaRepository<Saisie, UUID> {
    public Saisie findByIdSaisie(UUID idSaisie);
}
