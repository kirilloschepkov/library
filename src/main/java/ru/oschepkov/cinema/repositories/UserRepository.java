package ru.oschepkov.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oschepkov.cinema.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
