package ua.masaltsev.oleksarecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.oleksarecipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
