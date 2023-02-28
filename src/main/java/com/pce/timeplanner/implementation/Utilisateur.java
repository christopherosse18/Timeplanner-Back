package com.pce.timeplanner.implementation;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

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
    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST,targetEntity = Service.class)
    private Set<Service> service;


}
