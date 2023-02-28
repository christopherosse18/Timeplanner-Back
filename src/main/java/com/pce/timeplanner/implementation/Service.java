package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
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
    List<Jours> joursActifs = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;
}
