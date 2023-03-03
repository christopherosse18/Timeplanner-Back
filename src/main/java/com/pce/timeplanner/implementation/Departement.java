package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="departement")
public class Departement {
    /*@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id_service",columnDefinition = "serial")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_departement")
    private UUID idDepartement;
    String nom;
    /*@ElementCollection(targetClass = Jours.class)*/
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE,targetEntity = ContratJour.class)
    @JoinColumn(name = "id_departement")
    List<ContratJour> contratJours;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JsonBackReference
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", nullable = true)
    private Utilisateur utilisateur;


}
