package ua.masaltsev.oleksarecipeapp.service;

import ua.masaltsev.oleksarecipeapp.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    Optional<Recipe> findByDescription(String description);
    Recipe save(Recipe recipe);
    Optional<Recipe> findById(Long aLong);
    List<Recipe> findAll();
    void deleteById(Long aLong);
    void delete(Recipe recipe);
}
