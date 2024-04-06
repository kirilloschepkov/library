package ru.oschepkov.cinema.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.dto.user.InputUserDTO;
import ru.oschepkov.cinema.dto.user.OutputUserDTO;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.mappers.user.InputUserMapper;
import ru.oschepkov.cinema.mappers.user.OutputUserMapper;
import ru.oschepkov.cinema.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final OutputUserMapper outputUserMapper;
    private final InputUserMapper inputUserMapper;

    public List<OutputUserDTO> getAllUsers() {
        return repository
                .findAll()
                .stream()
                .map(outputUserMapper::convertFromEntity)
                .toList();
    }


    public OutputUserDTO getUserById(Long id) {
        UserEntity userEntity = repository.findById(id).orElse(null);
        return outputUserMapper.convertFromEntity(userEntity);
    }

    public OutputUserDTO getUserByToken(String token) {
        UserEntity userEntity = repository.findUserEntitiesByToken(token);
        return outputUserMapper.convertFromEntity(userEntity);
    }

    public OutputUserDTO createUser(InputUserDTO user) {
        UserEntity userEntity = inputUserMapper.convertFromDTO(user);
        UserEntity savedUserEntity = repository.save(userEntity);
        return outputUserMapper.convertFromEntity(savedUserEntity);
    }


    public OutputUserDTO updateUserById(Long id, InputUserDTO user) {
        UserEntity userEntity = inputUserMapper.convertFromDTO(user);
        userEntity.setId(id);
        UserEntity updatedUserEntity = repository.save(userEntity);
        return outputUserMapper.convertFromEntity(updatedUserEntity);
        // вопрос: Как организовать метод PATCH? Появление ошибки при передаче не всех параметров (отсутствие токена в сущности сохраняемого объекта).
    }


    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
