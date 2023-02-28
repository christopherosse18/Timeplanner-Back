package com.pce.timeplanner.implementation;


import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;
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
    @OneToMany(mappedBy = "temps", fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST,targetEntity = SemaineTravail.class)
    Set<SemaineTravail> semaineTravail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = Utilisateur.class)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

}
