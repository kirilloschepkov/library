package ru.oschepkov.cinema.mappers.film;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.film.InputFilmDTO;
import ru.oschepkov.cinema.entities.FilmEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class InputFilmMapper {
    private final ModelMapper modelMapper;

    public FilmEntity convertFromDTO(InputFilmDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, FilmEntity.class);
    }
}
