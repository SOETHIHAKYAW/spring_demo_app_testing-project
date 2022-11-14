package com.hostmdy.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

import com.hostmdy.demo.controllers.CategoryController;
import com.hostmdy.demo.domain.Category;
import com.hostmdy.demo.services.CategoryService;

class CategoryControllerTest {
	
	@Mock
	CategoryService categoryService;
	
	@Mock
	Model model;
	
	CategoryController categoryController;

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		categoryController = new CategoryController(categoryService);
		
	}

	@Test
	void mockMVCTest() throws Exception {
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(categoryController).build();
		mockMVC.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("category"));
	}
	
	@Test
	void getIndexPage() {
		Category category1 = new Category();
		Category category2 = new Category();
		category1.setId(2L);
		
		Set<Category> categorySet = new HashSet<>();
		categorySet.add(category1);
		categorySet.add(category2);
		
		when(categoryService.getCategory()).thenReturn(categorySet);
		
		ArgumentCaptor<Set<Category>> captor = ArgumentCaptor.forClass(Set.class);
		
		String viewName = categoryController.getIndexPage(model);
		
		verify(categoryService,times(1)).getCategory();
		verify(model,times(1)).addAttribute(eq("category"),captor.capture());
		Set<Category> category = captor.getValue();
		
		assertEquals(category.size(), 2);
		assertEquals(viewName, "category");
	}

}
