package com.hostmdy.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostmdy.demo.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CategoryController {
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@RequestMapping({"", "/", "/category"})
//	@RequestMapping("/category")
	public String getIndexPage(Model model) {
		
		log.debug("Spring Testing-Assignment");
		log.debug("Getting Index page");
		
		
		((Model) model).addAttribute("category",categoryService.getCategory());
		return "category";
		
	}

}
