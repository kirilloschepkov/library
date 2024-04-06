package ru.oschepkov.cinema.mappers.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.user.OutputUserDTO;
import ru.oschepkov.cinema.entities.UserEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class OutputUserMapper {
    private final ModelMapper modelMapper;

    public OutputUserDTO convertFromEntity(UserEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, OutputUserDTO.class);
    }

    public UserEntity convertFromDTO(OutputUserDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, UserEntity.class);
    }
}
