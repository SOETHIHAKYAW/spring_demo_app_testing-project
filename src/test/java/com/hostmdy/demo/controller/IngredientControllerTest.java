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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.hostmdy.demo.controllers.IngredientController;
import com.hostmdy.demo.domain.Ingredient;
import com.hostmdy.demo.services.IngredientService;

class IngredientControllerTest {
	
	@Mock
	IngredientService ingredientService;
	
	@Mock
	Model model;
	
	IngredientController ingredientController;

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		ingredientController = new IngredientController(ingredientService);
		
	}

	@Test
	void MockMVCTest() throws Exception {
		
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(ingredientController).build();
		mockMVC.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("ingredient"));
		
	}
	
	@Test
	void getIndexPage() {
		
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		ingredient1.setId(3L);
		
		Set<Ingredient> ingredientSet = new HashSet<>();
		ingredientSet.add(ingredient1);
		ingredientSet.add(ingredient2);
		
		when(ingredientService.getIngredient()).thenReturn(ingredientSet);
		
		ArgumentCaptor<Set<Ingredient>> captor = ArgumentCaptor.forClass(Set.class);
		
		String viewName = ingredientController.getIndexPage(model);
		
		verify(ingredientService,times(1)).getIngredient();
		verify(model,times(1)).addAttribute(eq("ingredient"),captor.capture());
		
		Set<Ingredient> ingredients = captor.getValue();
		assertEquals(ingredients.size(), 2);
		assertEquals(viewName, "ingredient");
		
	}

}
