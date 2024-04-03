package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.dto.UserDTO;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.mappers.UserMapper;
import ru.oschepkov.cinema.services.UserService;

import java.util.List;

@Tag(name = "Пользователи")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @Operation(
            summary = "Получить всех пользователей",
            description = "Возвращает список из всех пользователей"
    )
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service
                .getAllUsers()
                .stream()
                .map(mapper::convertFromEntity)
                .toList();
    }

    @Operation(
            summary = "Получить пользователя по идентификатору",
            description = "Возвращает пользователя с идентификатором id."
    )
    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return mapper.convertFromEntity(service.getUserById(userId));
    }

    @Operation(
            summary = "Получить пользователя по токену",
            description = "Возвращает пользователя с токеном token."
    )
    @GetMapping("/{userToken}")
    public UserDTO getUserByToken(@PathVariable String userToken) {
        return mapper.convertFromEntity(service.getUserByToken(userToken));
    }

    @Operation(
            summary = "Создать пользователя",
            description = "Создает нового пользователя."
    )
    @PostMapping
    public UserDTO createUser(@RequestBody UserEntity user) {
        return mapper.convertFromEntity(service.createUser(user));
    }


    @Operation(
            summary = "Изменить пользователя",
            description = "Изменяет данные пользователя с идентификатором id."
    )
    @PutMapping("/{userId}")
    public UserDTO updateFilm(@PathVariable Long userId, @RequestBody UserEntity user) {
        user.setId(userId);
        UserEntity updatedUser = service.updateUser(user);
        return mapper.convertFromEntity(updatedUser);
    }

    @Operation(
            summary = "Удалять пользователя",
            description = "Удаляет пользователя с идентификатором id."
    )
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        service.deleteUserById(userId);
    }
}
