package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="saisie")
public class Saisie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "id_saisie")
    private UUID idSaisie;

    @Enumerated(EnumType.STRING)
    TypeSaisie typeSaisie;
    LocalTime heureDebut;
    LocalTime heureFin;
}
