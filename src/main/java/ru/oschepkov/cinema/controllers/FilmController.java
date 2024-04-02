package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.services.FilmService;

import java.util.List;

@Tag(name = "Фильмы")
@RestController
@RequestMapping("/films") // todo: соответствие роутам для фронта
public class FilmController {
    private final FilmService service;

    @Autowired
    public FilmController(FilmService service) {
        this.service = service;
    }


    @Operation(
            summary = "Получить все фильмы",
            description = "Возвращает массив фильмов. Каждый фильм описан в виде объекта."
    )
    @GetMapping
    public List<FilmEntity> getAllFilms() {
        return service.getAllFilms();
    }


    @Operation(
            summary = "Получить фильм",
            description = "Возвращает фильм с идентификатором id."
    )
    @GetMapping("/{id}")
    public FilmEntity getFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }


    @Operation(
            summary = "Получить список похожих фильмов",
            description = "Возвращает массив фильмов с тем же жанром, что и фильм с идентификатором id"
    )
    @GetMapping("/{id}/similar")
    public FilmEntity getSimilarFilm(@PathVariable Long id) {
        return null; // todo: схожие фильмы
    }


    @Operation(
            summary = "Добавить фильм",
            description = "Добавляет фильм переданный по схеме в теле post-запроса"
    )
    @PostMapping
    public FilmEntity createFilm(@RequestBody FilmEntity film) {
        return service.createFilm(film);
    }


    @Operation(
            summary = "Изменить фильм",
            description = "Изменяет фильм с идентификатором id на переданный в теле запроса"
    )
    @PutMapping("/{id}")
    public FilmEntity updateFilm(@PathVariable Long id, @RequestBody FilmEntity film) {
        film.setId(id);
        return service.updateFilm(film);
    }

    @Operation(
            summary = "Удалить фильм",
            description = "Удаляет фильм с идентификатором id из базы данных"
    )
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        service.deleteFilmById(id);
    }
}
