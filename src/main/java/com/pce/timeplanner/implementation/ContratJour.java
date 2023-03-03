package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="contratjour")
public class ContratJour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "id_contratjour")
    private UUID idContratJour;

    private String jour;
    private double duree;
}
