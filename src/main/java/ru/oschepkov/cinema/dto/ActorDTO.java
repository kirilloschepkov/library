package ru.oschepkov.cinema.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActorDTO {
    Long id;
    String first_name;
    String last_name;
}
