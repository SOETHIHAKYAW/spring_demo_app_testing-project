package com.hostmdy.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.hostmdy.demo.controllers.IndexController;
import com.hostmdy.demo.domain.Recipe;
import com.hostmdy.demo.services.RecipeService;

class IndexControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		controller = new IndexController(recipeService);
		
	}
	
	@Test
	void mockMVCTest() throws Exception {
		
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
		mockMVC.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("recipe"));
		
	}

	@Test
	void getIndexPage() {
		
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe2.setId(12L);
		
		Set<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe1);
		recipeData.add(recipe2);
		
		when(recipeService.getRecipes()).thenReturn(recipeData);
		
		ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);
		
//		Set<Recipe> recipes = recipeService.getRecipes();
		
		String viewName = controller.getIndexPage(model);
		
		verify(recipeService,times(1)).getRecipes();
		verify(model,times(1)).addAttribute(eq("recipes"),captor.capture());
		Set<Recipe> recipes = captor.getValue();
		
		assertEquals(recipes.size(), 2);
		assertEquals(viewName, "recipe");
		
	}

}
