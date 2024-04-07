package ru.oschepkov.cinema.dto.comment;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.oschepkov.cinema.dto.user.UserDTO;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDTO {
    Long id;
    Date date;
    UserDTO user;
    String comment;
    Double rating;
}
