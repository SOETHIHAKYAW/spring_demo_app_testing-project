package com.hostmdy.demo.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hostmdy.demo.domain.Category;
import com.hostmdy.demo.repositories.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}



	@Override
	public Set<Category> getCategory() {
		
		log.debug("I'm in the Category.");
		
		Set<Category> categorySet = new HashSet<>();
		categoryRepository.findAll().iterator().forEachRemaining(categorySet::add);
		
		return categorySet;
	}

}
