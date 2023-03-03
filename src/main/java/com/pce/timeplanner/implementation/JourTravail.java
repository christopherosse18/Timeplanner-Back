package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="jourtravail")
public class JourTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_jourtravail")
    private UUID idJourTravail;
    LocalDate date;
    double duree;
    double tempsRealise;

    @OneToMany(/*mappedBy = "temps",*/ fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE,targetEntity = Saisie.class)
    @JoinColumn(name = "id_jourtravail")
    Set<Saisie> saisies;

    /*@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_semainetravail")
    SemaineTravail semaineTravail;*/
}
