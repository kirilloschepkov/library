package ru.oschepkov.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments", schema = "PUBLIC", catalog = "DB")
@Getter
@Setter
public class CommetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_sequence")
    @GenericGenerator(
            name = "comments_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "comments_sequence"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            })
    private Long id;

    @Column(name = "text")
    private String text;

    // todo: связи
    @Column(name = "user_id")
    private String userId;

    @Column(name = "film_id")
    private String filmId;
}
