package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="jourtravail")
public class JourTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotFound(action = NotFoundAction.IGNORE)
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
