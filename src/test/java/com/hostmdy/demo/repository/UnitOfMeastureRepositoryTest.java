package com.hostmdy.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hostmdy.demo.domain.UnitOfMeasure;
import com.hostmdy.demo.repositories.UnitOfMeasureRepository;

@DataJpaTest
class UnitOfMeastureRepositoryTest {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	

	@Test
	void findByDescriptionCupTest() {
		
		String testUnit = "Cup";  //expected value
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		UnitOfMeasure uomObject = uomOptional.get();
		
		assertEquals(testUnit, uomObject.getDescription());
		
	}
	
	@Test
	void findAllTest() {
		List<UnitOfMeasure> uomList = (List<UnitOfMeasure>) unitOfMeasureRepository.findAll();
		
		assertEquals(8, uomList.size());
	}


	@Test
	void findByDescriptionTablespoonTest() {
		
		String testUnit = "Tablespoon";
		UnitOfMeasure uomObject = unitOfMeasureRepository.findByDescription("Tablespoon").get();
		
		assertEquals(testUnit, uomObject.getDescription());
		
	}
	
}
