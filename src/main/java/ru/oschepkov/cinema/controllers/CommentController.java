package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.dto.CommentDTO;
import ru.oschepkov.cinema.entities.CommentEntity;
import ru.oschepkov.cinema.mappers.CommentMapper;
import ru.oschepkov.cinema.services.CommentService;

import java.util.List;

@Tag(name = "Комментарии")
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;
    private final CommentMapper mapper;


    @Operation(summary = "Получить комментарии", description = "Возвращает массив комментарием всех фильмов всеми пользователями")
    @GetMapping
    public List<CommentDTO> getAllComments() {
        return service
                .getAllComments()
                .stream()
                .map(mapper::convertFromEntity)
                .toList();
    }


    @Operation(summary = "Получить комментарий", description = "Возвращает комментарий с идентификатором id.")
    @GetMapping("/{commentId}")
    public CommentDTO getCommentById(@PathVariable Long commentId) {
        return mapper.convertFromEntity(service.getCommentsById(commentId));
    }


    @Operation(summary = "Получить комментарии к фильму", description = "Возвращает все комментарии к фильму с идентификатором id.")
    @GetMapping("/film/{filmId}")
    public List<CommentDTO> getCommentsByFilmId(@PathVariable Long filmId) {
        return service
                .getCommentsByFilmId(filmId)
                .stream()
                .map(mapper::convertFromEntity)
                .toList();
    }


    @Operation(summary = "Создать комментарий", description = "Создает новый комментарий.")
    @PostMapping
    public CommentDTO createComment(@RequestBody CommentEntity comment) {
        return mapper.convertFromEntity(service.createComment(comment));
    }
}
