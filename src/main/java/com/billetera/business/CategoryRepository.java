package com.billetera.business;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public List<Category> findById(Long categoryId);
	public List<Category> findByName(String categoryName);
}
