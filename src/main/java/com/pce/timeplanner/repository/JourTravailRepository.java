package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.JourTravail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface JourTravailRepository extends JpaRepository<JourTravail, UUID> {
    public JourTravail getJourTravailByDate(LocalDate date);
    public JourTravail getJourTravailByIdJourTravail(UUID idJourTravail);
}
