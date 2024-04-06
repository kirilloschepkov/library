package ru.oschepkov.cinema.dto.film;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmInListDTO {
    Long id; // incongruity typing
    String name;
    String previewImage;
    String previewVideoLink;
    String genre; // todo: only name of genre
}
