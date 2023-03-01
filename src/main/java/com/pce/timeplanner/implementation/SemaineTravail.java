package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
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
    @JsonManagedReference
    @OneToMany(/*mappedBy = "semaineTravail",*/ fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = JourTravail.class)
    @JoinColumn(name = "id_semainetravail")
    Set<JourTravail> jours;
    float heuresRealisees;
    float heuresDues;

    /*@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_temps")
    private Temps temps;*/

}
