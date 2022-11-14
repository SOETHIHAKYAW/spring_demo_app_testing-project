package com.hostmdy.demo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hostmdy.demo.domain.Ingredient;
import com.hostmdy.demo.repositories.IngredientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{
	
	private final IngredientRepository ingredientRepository;

	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}



	@Override
	public Set<Ingredient> getIngredient() {
		
		log.debug("I'm in Ingredient");
		
		Set<Ingredient> ingredientSet = new HashSet<>();

		ingredientRepository.findAll().iterator().forEachRemaining(ingredientSet::add);
		
		return ingredientSet;
	}
	
	

}
