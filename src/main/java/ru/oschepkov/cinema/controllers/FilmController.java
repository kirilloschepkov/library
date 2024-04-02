package ru.oschepkov.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.services.FilmService;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService service;

    @Autowired
    public FilmController(FilmService service) {
        this.service = service;
    }


    @GetMapping
    public List<FilmEntity> getAllFilms() {
        return service.getAllFilms();
    }


    @GetMapping("/{id}")
    public FilmEntity getFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }


    @PostMapping
    public FilmEntity createFilm(@RequestBody FilmEntity film) {
        return service.createFilm(film);
    }


    @PutMapping("/{id}")
    public FilmEntity updateFilm(@PathVariable Long id, @RequestBody FilmEntity film) {
        film.setId(id);
        return service.updateFilm(film);
    }


    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        service.deleteFilmById(id);
    }
}
