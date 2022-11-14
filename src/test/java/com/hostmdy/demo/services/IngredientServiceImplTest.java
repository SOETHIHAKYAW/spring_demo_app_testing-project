package com.hostmdy.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hostmdy.demo.domain.Ingredient;
import com.hostmdy.demo.repositories.IngredientRepository;

class IngredientServiceImplTest {
	
	IngredientServiceImpl ingredientService;
	
	@Mock
	IngredientRepository ingredientRepository;

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		ingredientService = new IngredientServiceImpl(ingredientRepository);
	}

	@Test
	void getIngredientTest() {
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		ingredient1.setId(3L);
		
		Set<Ingredient> ingredientSet = new HashSet<>();
		ingredientSet.add(ingredient1);
		ingredientSet.add(ingredient2);
		
		when(ingredientRepository.findAll()).thenReturn(ingredientSet);
		
		Set<Ingredient> ingredients = ingredientService.getIngredient();
		
		verify(ingredientRepository,times(1)).findAll();
		assertEquals(ingredients.size(), 2);
	}

}
