package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="semainetravail")
public class SemaineTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "id_semainetravail")
    private UUID idSemaineTravail;
    int numSemaine;
    @JsonManagedReference
    @OneToMany(/*mappedBy = "semaineTravail",*/ fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = JourTravail.class)
    @JoinColumn(name = "id_semainetravail")
    Set<JourTravail> joursTravail;
    float heuresRealisees;
    float heuresDues;

    static public int getCurrentWeek(){
        return LocalDate.now().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }
}
