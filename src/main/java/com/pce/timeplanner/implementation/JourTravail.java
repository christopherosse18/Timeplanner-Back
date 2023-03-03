package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="jourtravail")
public class JourTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_jourtravail")
    private UUID idJourTravail;
    @Enumerated(EnumType.STRING)
    Jours jours;
    double duree;
    double tempsRealise;
    @Enumerated(EnumType.STRING)
    TypeSaisie typeSaisie;
    float dureeSaisie;

    int annee;
    /*@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_semainetravail")
    SemaineTravail semaineTravail;*/
}
