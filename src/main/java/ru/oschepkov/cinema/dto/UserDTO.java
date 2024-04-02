package ru.oschepkov.cinema.dto;

import lombok.Getter;
import lombok.Setter;
import ru.oschepkov.cinema.entities.CommentEntity;
import ru.oschepkov.cinema.entities.FilmEntity;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String avatarURL;
    private String email;
    private String token;
    private Set<CommentEntity> comments;
    private Set<FilmEntity> favoriteFilms;
}
