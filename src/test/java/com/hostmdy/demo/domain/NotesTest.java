package com.hostmdy.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotesTest {
	
	Notes notes;

	@BeforeEach
	void setUp() throws Exception {
		notes = new Notes();
	}

	@Test
	void test() {
		
		Long id = 10L;
		notes.setId(id);
		assertEquals(id, notes.getId());
		
		String recipeNotes = "This is RecipeNotes.";
		notes.setRecipeNotes(recipeNotes);
		assertNotNull(recipeNotes);
		
	}

}
