package ru.oschepkov.cinema.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.services.UserService;

import java.util.List;

@Tag(name = "Пользователи")
@RestController
@RequestMapping("/users") // todo: соответствие роутам для фронта
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/{token}")
    public UserEntity getUserByToken(@PathVariable String token) {
        return service.getUserByToken(token);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return service.createUser(user);
    }


    @PutMapping("/{id}")
    public UserEntity updateFilm(@PathVariable Long id, @RequestBody UserEntity user) {
        user.setId(id);
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUserById(id);
    }
}
