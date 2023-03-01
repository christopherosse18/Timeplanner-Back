package com.pce.timeplanner.implementation;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@Table(name="temps")
public class Temps {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id_temps")
    private int idTemps;
    @OneToMany(/*mappedBy = "temps",*/ fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = SemaineTravail.class)
    @JoinColumn(name = "id_temps")
    Set<SemaineTravail> semaineTravail;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, targetEntity = Utilisateur.class)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

}
