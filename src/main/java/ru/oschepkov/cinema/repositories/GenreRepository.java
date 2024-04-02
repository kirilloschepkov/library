package ru.oschepkov.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oschepkov.cinema.entities.GenreEntity;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}

