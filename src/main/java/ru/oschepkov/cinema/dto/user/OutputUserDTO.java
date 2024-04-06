package ru.oschepkov.cinema.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutputUserDTO {
    private String name;
    private String avatarURL;
    private String email;
    private String token;
}
