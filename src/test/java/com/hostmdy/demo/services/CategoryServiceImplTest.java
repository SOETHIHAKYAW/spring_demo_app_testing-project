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

import com.hostmdy.demo.domain.Category;
import com.hostmdy.demo.repositories.CategoryRepository;

class CategoryServiceImplTest {
	
	CategoryServiceImpl categoryService;
	
	@Mock
	CategoryRepository categoryRepository;

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		categoryService = new CategoryServiceImpl(categoryRepository);
	}

	@Test
	void getCategoryTest() {
		Category category1 = new Category();
		Category category2 = new Category();
		category1.setId(2L);
		
		Set<Category> categorySet = new HashSet<>();
		categorySet.add(category1);
		categorySet.add(category2);
		
		when(categoryRepository.findAll()).thenReturn(categorySet);
		
		Set<Category> category = categoryService.getCategory();
		verify(categoryRepository,times(1)).findAll();
		assertEquals(category.size(), 2);
	}

}
