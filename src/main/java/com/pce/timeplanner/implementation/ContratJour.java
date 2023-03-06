package com.pce.timeplanner.implementation;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
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
    @Nullable
    private double duree;
    private boolean conge;
}
