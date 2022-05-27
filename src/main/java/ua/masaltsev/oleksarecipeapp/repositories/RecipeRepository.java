package ua.masaltsev.oleksarecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
