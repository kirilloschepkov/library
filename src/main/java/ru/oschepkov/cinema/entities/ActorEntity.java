package ru.oschepkov.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "actors", schema = "PUBLIC", catalog = "DB")
@Getter
@Setter
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actors_sequence")
    @GenericGenerator(
            name = "actors_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "actors_sequence"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            })
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @ManyToMany(mappedBy = "actors")
    private Set<FilmEntity> films;
}
