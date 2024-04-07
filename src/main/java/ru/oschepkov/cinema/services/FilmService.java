package ru.oschepkov.cinema.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.dto.film.FilmDTO;
import ru.oschepkov.cinema.dto.film.FilmInListDTO;
import ru.oschepkov.cinema.dto.film.FilmPromoDTO;
import ru.oschepkov.cinema.dto.film.InputFilmDTO;
import ru.oschepkov.cinema.entities.FilmEntity;
import ru.oschepkov.cinema.mappers.film.FilmMapper;
import ru.oschepkov.cinema.repositories.FilmRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository repository;
    private final FilmMapper filmMapper;


    public List<FilmInListDTO> getAllFilms() {
        return repository
                .findAll()
                .stream()
                .map(filmMapper::convertToFilmInListFromEntity)
                .toList();
    } // todo: add data about previewImage and previewVideoLink on db


    public FilmDTO getFilmById(Long id) {
        return filmMapper.convertToFilmDTOFromEntity(repository.findById(id).orElse(null));
    }

    public FilmPromoDTO getPromoFilmById(Long id) {
        return filmMapper.convertToFilmPromoFromEntity(repository.findById(id).orElse(null));
    }


    public List<FilmInListDTO> getSimilarFilmById(Long id) {
        FilmEntity filmEntity = repository.findById(id).orElse(null);
        List<FilmEntity> filmEntitiesByGenre = repository.findFilmEntitiesByGenre(filmEntity.getGenre());
        return filmEntitiesByGenre
                .stream()
                .map(filmMapper::convertToFilmInListFromEntity)
                .toList();
    }

// todo: add connection to dependencies in db
    public FilmDTO createFilm(InputFilmDTO film) {
        FilmEntity entity = filmMapper.convertToFilmEntityFromInputFilmDTO(film);
        return filmMapper.convertToFilmDTOFromEntity(repository.save(entity));
    }


    public FilmDTO updateFilm(Long id, InputFilmDTO film) {
        FilmEntity filmEntity = filmMapper.convertToFilmEntityFromInputFilmDTO(film);
        filmEntity.setId(id);
        FilmEntity updatedFilm = repository.save(filmEntity);
        return filmMapper.convertToFilmDTOFromEntity(updatedFilm);
    }

// todo: cascade
    public void deleteFilmById(Long id) {
        repository.deleteById(id);
    }
}
