package ru.oschepkov.cinema.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.UserDTO;
import ru.oschepkov.cinema.entities.UserEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserDTO convertFromEntity(UserEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, UserDTO.class);
    }

    public UserEntity convertFromDTO(UserDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, UserEntity.class);
    }
}
