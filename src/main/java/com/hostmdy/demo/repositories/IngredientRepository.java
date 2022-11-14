package com.hostmdy.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.demo.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{


}
