package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="utilisateur")
public class Utilisateur extends Person {

    /*@Autowired*/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_utilisateur")
    private UUID idUtilisateur;

    @Email(message = "Format incorrect")
    @Size(min = 5, message = "Doit être plus grand que 5")
    private String email;
    @JsonManagedReference
    @OneToMany(mappedBy = "utilisateur", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Departement> departements;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Temps.class)
    @JoinColumn(name = "id_temps")
    private Temps temps;


}
