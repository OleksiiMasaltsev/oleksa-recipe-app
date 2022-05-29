package ua.masaltsev.oleksarecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.masaltsev.oleksarecipeapp.domain.Category;
import ua.masaltsev.oleksarecipeapp.domain.UnitOfMeasure;
import ua.masaltsev.oleksarecipeapp.repositories.CategoryRepository;
import ua.masaltsev.oleksarecipeapp.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex() {

        Optional<Category> optionalCategory = categoryRepository.findByDescription("Mexican");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category ID is: " + optionalCategory.get().getId());
        System.out.println("UOM ID is: " + optionalUnitOfMeasure.get().getId());

        return "index";
    }

}
