package ru.oschepkov.cinema.mappers.film;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.film.FilmDTO;
import ru.oschepkov.cinema.dto.film.FilmInListDTO;
import ru.oschepkov.cinema.dto.film.FilmPromoDTO;
import ru.oschepkov.cinema.dto.film.InputFilmDTO;
import ru.oschepkov.cinema.entities.FilmEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FilmMapper{
    private final ModelMapper modelMapper;
    public FilmDTO convertToFilmDTOFromEntity(FilmEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, FilmDTO.class);
    }

    public FilmInListDTO convertToFilmInListFromEntity(FilmEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, FilmInListDTO.class);
    }

    public FilmPromoDTO convertToFilmPromoFromEntity(FilmEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, FilmPromoDTO.class);
    }

    public FilmEntity convertToFilmEntityFromInputFilmDTO(InputFilmDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, FilmEntity.class);
    }
}
