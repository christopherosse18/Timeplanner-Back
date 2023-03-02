package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;
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
    double tauxActivite;
    double heures;
    /*@ElementCollection(targetClass = Jours.class)*/
    @Enumerated(value= EnumType.STRING)
    List<Jours> joursActifs;

    public Departement(){};
    public Departement(UUID idDepartement, String nom, double tauxActivite, double heures, List<Jours> joursActifs) {
        this.idDepartement = idDepartement;
        this.nom = nom;
        this.tauxActivite = tauxActivite;
        this.heures = heures;
        this.joursActifs = joursActifs;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JsonBackReference
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", nullable = true)
    private Utilisateur utilisateur;
}
