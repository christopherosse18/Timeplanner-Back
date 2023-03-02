package com.pce.timeplanner.implementation;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="temps")
public class Temps {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_temps")
    private UUID idTemps;
    @OneToMany(/*mappedBy = "temps",*/ fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = SemaineTravail.class)
    @JoinColumn(name = "id_temps")
    Set<SemaineTravail> semaineTravail;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, targetEntity = Utilisateur.class)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

}
