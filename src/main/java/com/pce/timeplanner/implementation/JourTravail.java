package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="jourtravail")
public class JourTravail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id_jourtravail")
    private int idJourTravail;
    Jours jours;
    double duree;
    double tempsRealise;
    TypeSaisie typeSaisie;
    float dureeSaisie;

    int annee;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_semainetravail")
    SemaineTravail semaineTravail;
}
