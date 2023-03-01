package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
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
