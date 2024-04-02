package ru.oschepkov.cinema.dto;

import lombok.Getter;
import lombok.Setter;
import ru.oschepkov.cinema.entities.FilmEntity;

import java.util.Set;

@Getter
@Setter
public class GenreDTO {
    private Long id;
    private String name;
    private Set<FilmEntity> films;
}
