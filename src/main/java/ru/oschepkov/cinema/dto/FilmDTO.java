package ru.oschepkov.cinema.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

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
    // List<String> starring;
    Integer runTime;
    GenreDTO genre;
    String released;
}
