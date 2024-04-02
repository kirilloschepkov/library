package ru.oschepkov.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "films", schema = "PUBLIC", catalog = "DB")
@Getter
@Setter
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "films_sequence")
    // todo: связь? зачем GenericGenerator?
    @GenericGenerator(
            name = "films_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "films_sequence"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            })
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "poster_image")
    private String posterImage;

    @Column(name = "background_image")
    private String backgroundImage;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "scores_count")
    private Integer scoresCount;

    @Column(name= "director")
    private String director;

    @Column(name = "starring")
    private List<String> starring; // todo: массив

    @Column(name = "run_time")
    private Integer runTime;

    @Column(name = "genre_id", insertable = false, updatable = false)
    private Long genreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

    @Column(name = "released")
    private String released;

    @OneToMany(mappedBy = "film")
    private List<CommentEntity> comments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favorite_films",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private Set<UserEntity> likedUsers;
}

//todo: каскадность
