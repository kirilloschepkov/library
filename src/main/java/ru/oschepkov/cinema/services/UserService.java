package ru.oschepkov.cinema.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.dto.user.InputUserDTO;
import ru.oschepkov.cinema.dto.user.UserDTO;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.mappers.user.UserMapper;
import ru.oschepkov.cinema.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return repository
                .findAll()
                .stream()
                .map(userMapper::convertToUserDTOFromEntity)
                .toList();
    }


    public UserDTO getUserById(Long id) {
        UserEntity userEntity = repository.findById(id).orElse(null);
        return userMapper.convertToUserDTOFromEntity(userEntity);
    }

    public UserDTO getUserByToken(String token) {
        UserEntity userEntity = repository.findUserEntitiesByToken(token);
        return userMapper.convertToUserDTOFromEntity(userEntity);
    }

    public UserDTO createUser(InputUserDTO user) {
        UserEntity userEntity = userMapper.convertToUserEntityFromDTO(user);
        UserEntity savedUserEntity = repository.save(userEntity);
        return userMapper.convertToUserDTOFromEntity(savedUserEntity);
    }


    public UserDTO updateUserById(Long id, InputUserDTO user) {
        UserEntity userEntity = userMapper.convertToUserEntityFromDTO(user);
        userEntity.setId(id);
        UserEntity updatedUserEntity = repository.save(userEntity);
        return userMapper.convertToUserDTOFromEntity(updatedUserEntity);
        // вопрос: Как организовать метод PATCH? Появление ошибки при передаче не всех параметров (отсутствие токена в сущности сохраняемого объекта).
    }


    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
