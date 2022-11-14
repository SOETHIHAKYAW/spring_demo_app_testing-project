package com.hostmdy.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostmdy.demo.services.IngredientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IngredientController {
	
	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}
	
	@RequestMapping({ "", "/", "/ingredient"})
//	@RequestMapping("/ingredient")
	public String getIndexPage(Model model) {
		
		log.debug("Getting Index page");
		
		model.addAttribute("ingredient",ingredientService.getIngredient());
		return "ingredient";
		
	}

}
