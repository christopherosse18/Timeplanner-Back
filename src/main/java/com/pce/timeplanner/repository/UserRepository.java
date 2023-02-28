package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findAllByNom(String nom);

}
