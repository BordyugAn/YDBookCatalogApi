package ru.catalog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "books")


@Entity
//@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<BookEntity> books;

    public CategoryEntity(String name, BookEntity... books) {
        this.name = name;
        this.books = Stream.of(books).collect(Collectors.toSet());
        this.books.forEach(x -> x.setCategory(this));
    }

    public CategoryEntity() {
    }
}