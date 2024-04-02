package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.dto.FilmDTO;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.mappers.FilmMapper;
import ru.oschepkov.cinema.services.FilmService;

import java.util.List;

@Tag(name = "Фильмы")
@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService service;
    private final FilmMapper filmMapper;

    @Operation(
            summary = "Получить все фильмы",
            description = "Возвращает массив фильмов. Каждый фильм описан в виде объекта."
    )
    @GetMapping
    public List<FilmDTO> getAllFilms() {
        return service
                .getAllFilms()
                .stream()
                .map(filmMapper::convertFromEntity)
                .toList();
    }


    @Operation(
            summary = "Получить фильм",
            description = "Возвращает фильм с идентификатором id."
    )
    @GetMapping("/{filmId}")
    public FilmDTO getFilmById(@PathVariable Long filmId) {
        return filmMapper.convertFromEntity(service.getFilmById(filmId)); // todo: обработка запроса отсутствующего фильма
    }


    @Operation(
            summary = "Получить список похожих фильмов",
            description = "Возвращает массив фильмов с тем же жанром, что и фильм с идентификатором id"
    )
    @GetMapping("/{filmId}/similar")
    public List<FilmDTO> getSimilarFilm(@PathVariable Long filmId) {
        return service
                .getSimilarFilmById(filmId)
                .stream()
                .map(filmMapper::convertFromEntity)
                .toList();
    }


    @Operation(
            summary = "Добавить фильм",
            description = "Добавляет фильм переданный по схеме в теле post-запроса"
    )
    @PostMapping
    public FilmDTO createFilm(@RequestBody FilmEntity film) {
        return filmMapper.convertFromEntity(service.createFilm(film));
    }


    @Operation(
            summary = "Изменить фильм",
            description = "Изменяет фильм с идентификатором id на переданный в теле запроса"
    )
    @PutMapping("/{filmId}")
    public FilmDTO updateFilm(@PathVariable Long filmId, @RequestBody FilmEntity film) { // todo: схема для добавления фильма
        film.setId(filmId);
        FilmEntity updatedFilm = service.updateFilm(film);
        return filmMapper.convertFromEntity(updatedFilm);
    }

    @Operation(
            summary = "Удалить фильм",
            description = "Удаляет фильм с идентификатором id из базы данных"
    )
    @DeleteMapping("/{filmId}")
    public void deleteFilm(@PathVariable Long filmId) {
        service.deleteFilmById(filmId);
    }
}
