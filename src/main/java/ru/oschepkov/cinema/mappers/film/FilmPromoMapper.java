package ru.oschepkov.cinema.mappers.film;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.film.FilmPromoDTO;
import ru.oschepkov.cinema.entities.FilmEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FilmPromoMapper {
    private final ModelMapper modelMapper;

    public FilmPromoDTO convertFromEntity(FilmEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, FilmPromoDTO.class);
    }
}
