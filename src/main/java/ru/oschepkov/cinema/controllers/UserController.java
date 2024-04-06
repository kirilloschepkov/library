package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.dto.user.InputUserDTO;
import ru.oschepkov.cinema.dto.user.OutputUserDTO;
import ru.oschepkov.cinema.services.UserService;

import java.util.List;

@Tag(name = "Пользователи")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @Operation(
            summary = "Получить всех пользователей",
            description = "Возвращает список из всех пользователей"
    )
    @GetMapping
    public List<OutputUserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @Operation(
            summary = "Получить пользователя по идентификатору",
            description = "Возвращает пользователя с идентификатором id."
    )
    @GetMapping("/id/{userId}")
    public OutputUserDTO getUserById(@PathVariable Long userId) {
        return service.getUserById(userId);
    }

    @Operation(
            summary = "Получить пользователя по токену",
            description = "Возвращает пользователя с токеном token."
    )
    @GetMapping("/token/{userToken}")
    public OutputUserDTO getUserByToken(@PathVariable String userToken) {
        return service.getUserByToken(userToken);
    }

    @Operation(
            summary = "Создать пользователя",
            description = "Создает нового пользователя."
    )
    @PostMapping
    public OutputUserDTO createUser(@RequestBody InputUserDTO user) {
        return service.createUser(user);
    }


    @Operation(
            summary = "Изменить пользователя",
            description = "Изменяет данные пользователя с идентификатором id."
    )
    @PutMapping("/{userId}")
    public OutputUserDTO updateUser(@PathVariable Long userId, @RequestBody InputUserDTO user) {
        return service.updateUserById(userId, user);
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
