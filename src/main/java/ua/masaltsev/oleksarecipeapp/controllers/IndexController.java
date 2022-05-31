package ua.masaltsev.oleksarecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;
import ua.masaltsev.oleksarecipeapp.service.impl.RecipeServiceImpl;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeServiceImpl recipeService;

    public IndexController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex() {

        log.debug("inside getIndex");

        Optional<Recipe> optionalRecipe = recipeService.findByDescription("Chicken");

        optionalRecipe.ifPresent(recipe -> System.out.println(recipe.getCookTime()));

        return "index";
    }

}
