package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@Entity
@Table(name="utilisateur")
public class Utilisateur extends Person {

    /*@Autowired*/
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id_utilisateur")
    private int idUtilisateur;

    @Email(message = "Format incorrect")
    @Size(min = 5, message = "Doit être plus grand que 5")
    private String email;
    @JsonManagedReference
    @ManyToMany/*(*//*mappedBy = "utilisateur",*//* fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = Service.class)*/
    /*@JoinColumn(name = "id_utilisateur")*/
    @JoinTable(
            name = "service",
            joinColumns = @JoinColumn(name = "id_utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "id_service"))
    private List<Service> service;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Temps.class)
    @JoinColumn(name = "id_temps")
    private Temps temps;


}
