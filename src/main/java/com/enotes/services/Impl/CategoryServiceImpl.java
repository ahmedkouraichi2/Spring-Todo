package com.enotes.services.Impl;

import org.apache.juli.logging.Log;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.enotes.UserValidator.CategoryValidator;
import com.enotes.exception.EntityNotFoundException;
import com.enotes.exception.ErrorCodes;
import com.enotes.exception.InvalidEntityException;
import com.enotes.repository.CategoryRepository;
import com.enotes.services.CategoryService;
import java.util.*;
import java.util.stream.Collectors;

import dto.CategoryDto;

public class CategoryServiceImpl implements CategoryService{
    
	 @Autowired
	    private CategoryRepository categoryRepository;
	
	@Override
	public CategoryDto save(CategoryDto category) {
		// TODO Auto-generated method stub
		
		List<String> errors =CategoryValidator.validateCategory(category);
		if(!errors.isEmpty()) {
			// log.error("Category is not valid {}", category);
			 throw new InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
		}
		return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(category)));
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll().stream()
				.map(CategoryDto::fromEntity)
				.collect(Collectors.toList());
		
	}

	@Override
	public CategoryDto findById(Long id) {
       if(id == null) {
    	  //  log.error("Category is not found");
    	    return null;
       } 
       return categoryRepository.findById(id).map(CategoryDto::fromEntity)
    		   .orElseThrow(() -> new EntityNotFoundException("No Category found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
		
	}

	@Override
	public List<CategoryDto> findAllByUserId(Long userId) {
		 return categoryRepository.findCategoryByUser(userId).stream()
				 .map(CategoryDto::fromEntity)
				 .collect(Collectors.toList());
		
	} 
	
	
	@Override
	
	public void delete(Long id) {
		 if(id == null) { 
			 //log.error("Category id is null");
			 
		 }
		 
		 categoryRepository.deleteById(id);
		 
		 
	}

	public List<CategoryDto> getAllTodoByCategoriesForToday(Long userId) {

		return categoryRepository.getAllTodoByCategoriesForToday(ZonedDateTime.now().withHour(0).withMinute(0),
			ZonedDateTime.now().withHour(23).withMinute(59),userId)
				.stream()
				  .map(CategoryDto::fromEntity)
				   .collect(Collectors.toList());
				
				
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
