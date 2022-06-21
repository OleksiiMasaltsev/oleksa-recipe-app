package ua.masaltsev.oleksarecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;
import ua.masaltsev.oleksarecipeapp.service.RecipeService;

import java.util.Optional;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        Optional<Recipe> optionalRecipe = recipeService.findById(Long.valueOf(id));
        optionalRecipe.ifPresent(model::addAttribute);
        return "recipe/show";
    }
}
