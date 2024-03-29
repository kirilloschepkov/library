package ru.oschepkov.library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "publisher", schema = "PUBLIC", catalog = "DB")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
}
