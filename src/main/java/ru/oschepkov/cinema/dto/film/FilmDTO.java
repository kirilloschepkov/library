package ru.oschepkov.cinema.dto.film;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmDTO {
    Long id;
    String name;
    String posterImage;
    String backgroundImage;
    String backgroundColor;
    String videoLink;
    String description;
    Double rating;
    Integer scoresCount;
    String director;
    Integer runTime;
    String genre; // todo: only name
    String released;
    Set<String> actors; // todo: only name
}
