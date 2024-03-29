package ru.oschepkov.library.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books", schema = "PUBLIC", catalog = "DB")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "publish_id")
    private PublisherEntity publisher;

    @Column(name = "publish_date")
    private Date publishDate;
}

//TODO: 1. Построение сущностей
