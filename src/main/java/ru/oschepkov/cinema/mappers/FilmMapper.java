package ru.oschepkov.cinema.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.FilmDTO;
import ru.oschepkov.cinema.entities.FilmEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FilmMapper {
    private final ModelMapper modelMapper;

    public FilmDTO convertFromEntity(FilmEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, FilmDTO.class);
    }

    public FilmEntity convertFromDTO(FilmDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, FilmEntity.class);
    }
}
