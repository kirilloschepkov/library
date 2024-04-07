package ru.oschepkov.cinema.dto.comment;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InputCommentDTO {
    String comment;
    Double rating;
}
