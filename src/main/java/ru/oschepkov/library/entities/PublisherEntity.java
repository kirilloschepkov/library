package ru.oschepkov.library.entities;

public class PublisherEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublisherEntity(String name) {
        this.name = name;
    }
}
