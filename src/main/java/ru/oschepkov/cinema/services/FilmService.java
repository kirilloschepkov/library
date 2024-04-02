package ru.oschepkov.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.repositories.FilmRepository;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository repository;

    @Autowired
    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    public List<FilmEntity> getAllFilms() {
        return repository.findAll();
    }


    public FilmEntity getFilmById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public FilmEntity createFilm(FilmEntity film) {
        return repository.save(film);
    }


    public FilmEntity updateFilm(FilmEntity film) {
        return repository.save(film);
    }


    public void deleteFilmById(Long id) {
        repository.deleteById(id);
    }
}
