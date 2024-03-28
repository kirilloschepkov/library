package ru.oschepkov.library.entities;

import java.util.Date;

public class BookEntity {
    private Long id;
    private String name;
    private PublisherEntity publisher;
    private Date publishDate;
}

//TODO: 1. Построение сущностей
// 2. Построение changelog
// 3. Заполнение changelog
