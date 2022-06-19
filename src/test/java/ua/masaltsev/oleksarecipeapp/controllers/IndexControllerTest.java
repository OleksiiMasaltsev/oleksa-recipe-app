package ua.masaltsev.oleksarecipeapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import ua.masaltsev.oleksarecipeapp.service.RecipeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void getHome_ViewNameIsRecipesHome_True() {

        String viewName = indexController.getHome(model);
        assertEquals("recipes_home", viewName);

        verify(recipeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("recipes"), anyList());
    }

    @Test
    void request_gets_recipe_home() throws Exception {
        MockMvc mockMvc = standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes_home"));
    }

    @Test
    void showById_requestByIdReturnsShow_True() throws Exception {
        MockMvc mockMvc = standaloneSetup(indexController).build();
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }
}