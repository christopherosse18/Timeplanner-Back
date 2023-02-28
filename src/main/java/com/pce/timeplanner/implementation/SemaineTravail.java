package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="semainetravail")
public class SemaineTravail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id_semainetravail")
    private int idSemaineTravail;
    int numSemaine;
    @OneToMany(mappedBy = "semaineTravail", fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST,targetEntity = JourTravail.class)
    Set<JourTravail> jours;
    float heuresRealisees;
    float heuresDues;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_temps")
    private Temps temps;

}
