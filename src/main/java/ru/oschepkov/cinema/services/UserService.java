package ru.oschepkov.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.oschepkov.cinema.entities.UserEntity;
import ru.oschepkov.cinema.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }


    public UserEntity getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserEntity getUserByToken(String token) {
        return null; // todo: поиск по токену
    }

    public UserEntity createUser(UserEntity user) {
        return repository.save(user);
    }


    public UserEntity updateUser(UserEntity user) {
        return repository.save(user);
    }


    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
