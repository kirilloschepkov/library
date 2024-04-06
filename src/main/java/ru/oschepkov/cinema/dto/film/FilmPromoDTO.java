package ru.oschepkov.cinema.dto.film;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmPromoDTO {
    Long id; // incongruity typing
    String name;
    String posterImage;
    String backgroundImage;
    String videoLink;
    String genre; // todo: only name of genre
    Integer released;
}
