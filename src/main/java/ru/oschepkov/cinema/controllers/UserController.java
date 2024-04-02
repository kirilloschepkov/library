package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.services.UserService;

import java.util.List;

@Tag(name = "Пользователи")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Operation(
            summary = "Получить всех пользователей",
            description = "Возвращает список из всех пользователей"
    )
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }

    @Operation(
            summary = "Получить пользователя по идентификатору",
            description = "Возвращает пользователя с идентификатором id."
    )
    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId) {
        return service.getUserById(userId);
    }

    @Operation(
            summary = "Получить пользователя по токену",
            description = "Возвращает пользователя с токеном token."
    )
    @GetMapping("/{userToken}")
    public UserEntity getUserByToken(@PathVariable String userToken) {
        return service.getUserByToken(userToken);
    }

    @Operation(
            summary = "Создать пользователя",
            description = "Создает нового пользователя."
    )
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return service.createUser(user);
    }


    @Operation(
            summary = "Изменить пользователя",
            description = "Изменяет данные пользователя с идентификатором id."
    )
    @PutMapping("/{userId}")
    public UserEntity updateFilm(@PathVariable Long userId, @RequestBody UserEntity user) {
        user.setId(userId);
        return service.updateUser(user);
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
