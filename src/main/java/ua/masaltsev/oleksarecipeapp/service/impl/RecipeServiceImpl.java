package ua.masaltsev.oleksarecipeapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;
import ua.masaltsev.oleksarecipeapp.repositories.RecipeRepository;
import ua.masaltsev.oleksarecipeapp.service.RecipeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Optional<Recipe> findByDescription(String description) {
        return recipeRepository.findByDescription(description);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> findById(Long aLong) {
        return recipeRepository.findById(aLong);
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public void deleteById(Long aLong) {
        recipeRepository.deleteById(aLong);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }
}
