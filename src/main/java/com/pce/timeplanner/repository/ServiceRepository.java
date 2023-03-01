package com.pce.timeplanner.repository;

import com.pce.timeplanner.implementation.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@RepositoryRestResource(path = "service")
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Service findByIdService(int id);
}
