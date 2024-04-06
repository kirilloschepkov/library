package ru.oschepkov.cinema.dto.genre;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreDTO {
    Long id;
    String name;
}
