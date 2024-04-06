package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.dto.film.FilmInListDTO;
import ru.oschepkov.cinema.dto.film.FilmPromoDTO;
import ru.oschepkov.cinema.dto.film.InputFilmDTO;
import ru.oschepkov.cinema.dto.film.FilmDTO;
import ru.oschepkov.cinema.services.FilmService;

import java.util.List;

@Tag(name = "Фильмы")
@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService service;

    @Operation(summary = "Получить все фильмы", description = "Возвращает массив данных фильмов.")
    @GetMapping
    public List<FilmInListDTO> getAllFilms() {
        return service.getAllFilms();
    }


    @Operation(summary = "Получить фильм", description = "Возвращает данные фильма с идентификатором id.")
    @GetMapping("/{filmId}")
    public FilmDTO getFilmById(@PathVariable Long filmId) {
        return service.getFilmById(filmId);
    }


    @Operation(summary = "Получить промо фильма", description = "Возвращает данные для промо-фильм с идентификатором id.")
    @GetMapping("/promo/{filmId}")
    public FilmPromoDTO getPromoFilmById(@PathVariable Long filmId) {
        return service.getPromoFilmById(filmId);
    }


    @Operation(summary = "Получить список похожих фильмов", description = "Возвращает массив данных фильмов с тем же жанром, что и фильм с идентификатором id")
    @GetMapping("/{filmId}/similar")
    public List<FilmInListDTO> getSimilarFilm(@PathVariable Long filmId) {
        return service.getSimilarFilmById(filmId);
    }


    @Operation(summary = "Добавить фильм", description = "Добавляет фильм переданный по схеме в теле post-запроса")
    @PostMapping
    public FilmDTO createFilm(@RequestBody InputFilmDTO film) {
        return service.createFilm(film);
    }


    @Operation(summary = "Изменить фильм", description = "Изменяет фильм с идентификатором id на переданный в теле запроса")
    @PutMapping("/{filmId}")
    public FilmDTO updateFilm(@PathVariable Long filmId, @RequestBody InputFilmDTO film) {
        return service.updateFilm(filmId, film);
    }

    @Operation(summary = "Удалить фильм", description = "Удаляет фильм с идентификатором id из базы данных")
    @DeleteMapping("/{filmId}")
    public void deleteFilm(@PathVariable Long filmId) {
        service.deleteFilmById(filmId);
    }
}
