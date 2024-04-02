package ru.oschepkov.cinema.dto;

import lombok.Getter;
import lombok.Setter;
import ru.oschepkov.cinema.entities.CommentEntity;
import ru.oschepkov.cinema.entities.GenreEntity;
import ru.oschepkov.cinema.entities.UserEntity;

import java.util.Set;

@Getter
@Setter
public class FilmDTO {
    private Long id;
    private String name;
    private String posterImage;
    private String backgroundImage;
    private String backgroundColor;
    private String videoLink;
    private String description;
    private Double rating;
    private Integer scoresCount;
    private String director;
//    private List<String> starring;
    private Integer runTime;
    private GenreEntity genre;
    private String released;
    private Set<CommentEntity> comments;
    private Set<UserEntity> likedUsers;
}
