package com.enotes.services;

import dto.CategoryDto;
import java.util.*;

public interface CategoryService {
	
	CategoryDto save(CategoryDto category);
	
	List<CategoryDto> findAll();
	
	CategoryDto findById(Long id);
	
	List<CategoryDto> findAllByUserId(Long userId);
	 
	 void delete(Long id);
	 
	 
	 List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);
	 
	 
	 


}
