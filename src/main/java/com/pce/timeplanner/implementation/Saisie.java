package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="saisie")
public class Saisie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_saisie")
    private UUID idSaisie;

    @Enumerated(EnumType.STRING)
    TypeSaisie typeSaisie;
    LocalDateTime heureDebut;
    LocalDateTime heureFin;
    float dureeSaisie;
}
