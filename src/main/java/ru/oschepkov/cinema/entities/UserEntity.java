package ru.oschepkov.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "users", schema = "PUBLIC", catalog = "DB")
@Getter
@Setter
@NoArgsConstructor // TODO: NoArgsConstructor?
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @GenericGenerator(
            name = "users_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "users_sequence"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            })
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar_url")
    private String avatarURL;

    @Column(name = "email")
    private String email;

    @Column(name = "token")
    private String token;

    @OneToMany(mappedBy = "user")
    private Set<CommentEntity> comments;

    @ManyToMany(mappedBy = "likedUsers")
    private Set<FilmEntity> favoriteFilms;
}
