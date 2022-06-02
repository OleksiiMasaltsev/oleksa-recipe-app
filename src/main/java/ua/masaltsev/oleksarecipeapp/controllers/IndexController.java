package ua.masaltsev.oleksarecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;
import ua.masaltsev.oleksarecipeapp.service.impl.RecipeServiceImpl;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    private final RecipeServiceImpl recipeService;

    public IndexController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model) {

        log.debug("inside getIndex");
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);

        return "index";
    }

}
