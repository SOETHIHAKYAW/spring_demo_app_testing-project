package com.hostmdy.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostmdy.demo.services.CategoryService;
import com.hostmdy.demo.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/recipe" })
//	@RequestMapping("/recipe")
	public String getIndexPage(Model model) {
		log.debug("Getting Index page");

		model.addAttribute("recipes", recipeService.getRecipes());

		return "recipe";
	}
}
