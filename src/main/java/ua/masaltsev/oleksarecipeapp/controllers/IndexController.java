package ua.masaltsev.oleksarecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;
import ua.masaltsev.oleksarecipeapp.service.RecipeService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getHome(Model model) {
        log.debug("debug - inside getHome");
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);

        return "recipes_home";
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        System.out.println("inside showById");
        Optional<Recipe> optionalRecipe = recipeService.findById(Long.valueOf(id));
        optionalRecipe.ifPresent(model::addAttribute);
        return "recipe/show";
    }

}
