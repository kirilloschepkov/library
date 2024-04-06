package ru.oschepkov.cinema.mappers.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.oschepkov.cinema.dto.user.InputUserDTO;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.utils.hash;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class InputUserMapper {
    private final ModelMapper modelMapper;

    public UserEntity convertFromDTO(InputUserDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        UserEntity entity = new UserEntity();
        modelMapper.map(dto, entity);

        entity.setToken(hash.getHash(dto.toString()));

        return entity;
    }
}
