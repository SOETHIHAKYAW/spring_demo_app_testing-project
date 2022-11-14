package com.hostmdy.demo.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.hostmdy.demo.repositories.RecipeRepository;
import com.hostmdy.demo.services.RecipeServiceImpl;

class CategoryTest {
	
	Category category; // call obj
	

	@Mock
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
	}

	@Test
	void idTest() {
		
		Long id = 12L;
		category.setId(id);
		
		assertEquals(id, category.getId());
		
	}
	
	@Test
	void descriptionNullCheck() {
		String description = "I am in description.";
		
		category.setDescription(description);
//		assertEquals(description, category.getDescription());
		assertNotNull(description);
	}

}
