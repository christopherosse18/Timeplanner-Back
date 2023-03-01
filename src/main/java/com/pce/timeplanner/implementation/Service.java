package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name="service")
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id_service")
    private int idService;
    String nom;
    double tauxActivite;
    double heures;
    /*@ElementCollection(targetClass = Jours.class)*/
    @Enumerated(value= EnumType.STRING)
    List<Jours> joursActifs = new ArrayList<>();
   /* @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;*/
}
