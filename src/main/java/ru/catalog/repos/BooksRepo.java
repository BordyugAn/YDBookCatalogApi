package ru.catalog.repos;

import org.springframework.data.repository.CrudRepository;
import ru.catalog.entity.BookEntity;

import javax.transaction.Transactional;

public interface BooksRepo extends CrudRepository<BookEntity, Long> {

    BookEntity findByName(String name);

    BookEntity findById(int id);

    @Transactional
    void deleteById(int id);

    @Transactional
    void deleteByName(String name);
}
