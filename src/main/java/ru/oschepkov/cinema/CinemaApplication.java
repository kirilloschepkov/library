package ru.oschepkov.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }
}

/*
* todo:
*   написать автотесты
*   исправление связей (несколько актеров к фильмы)
*   соответствие фронту: функции, роуты, схемы
*   ...
*   lombok
*   исключения
*   удаление (каскадность)
* */
