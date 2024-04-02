package ru.oschepkov.cinema.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String avatarURL;
    private String email;
    private String token;
}
