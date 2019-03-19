package ru.catalog.repos;

import org.springframework.data.repository.CrudRepository;
import ru.catalog.entity.CategoryEntity;

import javax.transaction.Transactional;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {

    CategoryEntity findByName(String name);

    @Transactional
    void deleteByName(String name);

    @Transactional
    void deleteById(int id);
}
