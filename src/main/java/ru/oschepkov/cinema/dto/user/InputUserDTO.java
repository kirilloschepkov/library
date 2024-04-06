package ru.oschepkov.cinema.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InputUserDTO {
    String name;
    String avatarURL;
    String email;
}
