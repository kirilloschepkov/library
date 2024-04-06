package ru.oschepkov.cinema.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.dto.film.FilmDTO;
import ru.oschepkov.cinema.dto.film.FilmInListDTO;
import ru.oschepkov.cinema.dto.film.FilmPromoDTO;
import ru.oschepkov.cinema.dto.film.InputFilmDTO;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.mappers.film.FilmInListMapper;
import ru.oschepkov.cinema.mappers.film.FilmMapper;
import ru.oschepkov.cinema.mappers.film.FilmPromoMapper;
import ru.oschepkov.cinema.mappers.film.InputFilmMapper;
import ru.oschepkov.cinema.repositories.FilmRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository repository;
    private final FilmMapper filmMapper;
    private final FilmInListMapper filmInListMapper;
    private final FilmPromoMapper filmPromoMapper;
    private final InputFilmMapper inputFilmMapper;
    // todo: create common generic mapper that can work with different DTO


    public List<FilmInListDTO> getAllFilms() {
        return repository
                .findAll()
                .stream()
                .map(filmInListMapper::convertFromEntity)
                .toList();
    } // todo: add data about previewImage and previewVideoLink on db


    public FilmDTO getFilmById(Long id) {
        return filmMapper.convertFromEntity(repository.findById(id).orElse(null));
    }

    public FilmPromoDTO getPromoFilmById(Long id) {
        var film = repository.findById(id).orElse(null);
        var res = filmPromoMapper.convertFromEntity(film);
        return res;
    }


    public List<FilmInListDTO> getSimilarFilmById(Long id) {
        FilmEntity filmEntity = repository.findById(id).orElse(null);
        List<FilmEntity> filmEntitiesByGenre = repository.findFilmEntitiesByGenre(filmEntity.getGenre());
        return filmEntitiesByGenre
                .stream()
                .map(filmInListMapper::convertFromEntity)
                .toList();
    }

// todo: add connection to dependencies in db
    public FilmDTO createFilm(InputFilmDTO film) {
        FilmEntity entity = inputFilmMapper.convertFromDTO(film);
        return filmMapper.convertFromEntity(repository.save(entity));
    }


    public FilmDTO updateFilm(Long id, InputFilmDTO film) {
        FilmEntity filmEntity = inputFilmMapper.convertFromDTO(film);
        filmEntity.setId(id);
        FilmEntity updatedFilm = repository.save(filmEntity);
        return filmMapper.convertFromEntity(updatedFilm);
    }

// todo: cascade
    public void deleteFilmById(Long id) {
        repository.deleteById(id);
    }
}
