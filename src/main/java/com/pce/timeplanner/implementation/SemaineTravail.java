package com.pce.timeplanner.implementation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pce.timeplanner.repository.JourTravailRepository;
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
@Table(name="semainetravail", uniqueConstraints={
        @UniqueConstraint(columnNames = {"id_temps", "numSemaine"})
})
public class SemaineTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotFound(action = NotFoundAction.IGNORE)
    @Column(name = "id_semainetravail")
    private UUID idSemaineTravail;
    int numSemaine;
    @JsonManagedReference
    @OneToMany(/*mappedBy = "semaineTravail",*/ fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE,targetEntity = JourTravail.class)
    @JoinColumn(name = "id_semainetravail")
    Set<JourTravail> joursTravail;
    float heuresRealisees;
    float heuresDues;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JsonBackReference
    @JoinColumn(name = "id_temps", referencedColumnName = "id_temps", nullable = true)
    Temps temps;

    static public int getCurrentWeek(){
        return LocalDate.now().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }
}
