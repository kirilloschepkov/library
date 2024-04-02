package ru.oschepkov.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oschepkov.cinema.entities.FilmEntity;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {}
