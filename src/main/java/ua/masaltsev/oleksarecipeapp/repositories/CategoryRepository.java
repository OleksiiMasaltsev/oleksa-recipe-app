package ua.masaltsev.oleksarecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.oleksarecipeapp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
