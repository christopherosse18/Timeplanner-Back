package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.Temps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempsRepository extends JpaRepository<Temps, Integer> {
}
