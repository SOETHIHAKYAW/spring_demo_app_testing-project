package com.hostmdy.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientTest {
	
	Ingredient ingredient; // call obj

	@BeforeEach
	void setUp() throws Exception {
		
		ingredient = new Ingredient();
	}

	@Test
	void idTest() {
		Long id = 10L;
		ingredient.setId(id);
		
		assertEquals(id, ingredient.getId());
	}
	
	@Test
	void descriptionNullTest() {
		
		String testString = "This is test String.";
		ingredient.setDescription(testString);
		
//		assertNull(ingredient.getDescription());
		assertNotNull(ingredient.getDescription());
		
	}
	@Test
	void amountTest() {
		BigDecimal amount = BigDecimal.valueOf(1000.234);
		
		ingredient.setAmount(amount);
		assertNotNull(ingredient.getAmount());
	}

}
