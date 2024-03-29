package ru.oschepkov.library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authors", schema = "PUBLIC", catalog = "DB")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;
}
