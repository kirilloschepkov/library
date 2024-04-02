package ru.oschepkov.cinema.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private Date date;
    private String comment;
    private Double rating;
    private FilmDTO film;
    private UserDTO user;
}
