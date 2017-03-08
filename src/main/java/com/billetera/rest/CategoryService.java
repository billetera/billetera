package com.billetera.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billetera.business.Category;
import com.billetera.business.CategoryRepository;

@RestController
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/save-category", method = RequestMethod.POST)
	public void saveCategory(@RequestBody Category category)	{
		
		categoryRepository.save(category);
	}
	
	@RequestMapping(value = "/get-categories", method = RequestMethod.GET)
	public List<Category> getCategories()	{
		
		List<Category> categories = new ArrayList<>();
		for(Category category: categoryRepository.findAll())	{
			
			categories.add(category);
		}
		
		return categories;
	}	
	
	@RequestMapping(value = "/get-categories-by-name", method = RequestMethod.GET)
	public List<Category> getCategories(@RequestBody String categoryName)	{
		
		return categoryRepository.findByName(categoryName);
	}		
}
