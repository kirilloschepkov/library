package ru.oschepkov.cinema.dto;

import lombok.Getter;
import lombok.Setter;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.entities.UserEntity;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private Date date;
    private String comment;
    private Double rating;
    private FilmEntity film;
    private UserEntity user;
}
