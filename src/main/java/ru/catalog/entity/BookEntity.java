package ru.catalog.entity;


import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "link", nullable = false)
    private String link;


    @ManyToOne
    @JoinColumn
    private CategoryEntity category;

    public BookEntity() {
    }

    public BookEntity(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
