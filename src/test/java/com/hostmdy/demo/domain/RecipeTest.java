package com.hostmdy.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeTest {
	
	Recipe recipe;

	@BeforeEach
	void setUp() throws Exception {
		recipe = new Recipe();
	}

	@Test
	void test() {
		Long id = 2L;
		recipe.setId(id);
		assertNotNull(id);
		
		String description = "This is Description.";
		recipe.setDescription(description);
		assertNotNull(description);
		
		Integer prepTime = 2;
		recipe.setPrepTime(prepTime);
		assertEquals(prepTime, recipe.getPrepTime());
		
		Integer cookTime = 3;
		recipe.setCookTime(cookTime);
		assertEquals(cookTime, recipe.getCookTime());
		
		Integer servings = 3;
		recipe.setServings(servings);
		assertEquals(servings, recipe.getServings());
		
		String source = "This is Source";
		recipe.setSource(source);
		assertEquals(source, recipe.getSource());
		
		String url = "This is url.";
		recipe.setUrl(url);
		assertEquals(url, recipe.getUrl());
	}

}
