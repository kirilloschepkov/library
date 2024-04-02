package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.entities.CommentEntity;
import ru.oschepkov.cinema.services.CommentService;

import java.util.List;

@Tag(name = "Комментарии")
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }


    @Operation(summary = "Получить комментарии", description = "Возвращает массив комментарием всех фильмов всеми пользователями")
    @GetMapping
    public List<CommentEntity> getAllComments() {
        return service.getAllComments();
    }


    @Operation(summary = "Получить комментарий", description = "Возвращает комментарий с идентификатором id.")
    @GetMapping("/{commentId}")
    public CommentEntity getCommentById(@PathVariable Long commentId) {
        return service.getCommentsById(commentId);
    }


    @Operation(summary = "Получить комментарии к фильму", description = "Возвращает все комментарии к фильму с идентификатором id.")
    @GetMapping("/film/{filmId}")
    public List<CommentEntity> getCommentByFilmId(@PathVariable Long filmId) {
        return service.getCommentsByFilmId(filmId);
    }


    @Operation(summary = "Создать комментарий", description = "Создает новый комментарий.")
    @PostMapping
    public CommentEntity createComment(@RequestBody CommentEntity comment) {
        return service.createComment(comment);
    }
}
