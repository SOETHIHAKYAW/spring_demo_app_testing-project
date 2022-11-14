package com.hostmdy.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitOfMeasureTest {

	UnitOfMeasure uom;
	
	@BeforeEach
	void setUp() throws Exception {
		uom = new UnitOfMeasure();
	}

	@Test
	void idTest() {
		Long id = 2L;
		uom.setId(id);
		assertNotNull(id);
	}
	
	@Test
	void descriptionTest() {
		String description = "This is Description.";
		assertNotNull(description);
	}

}
