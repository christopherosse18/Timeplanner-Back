package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path = "departement")
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    Departement findByIdDepartement(int id);
}
