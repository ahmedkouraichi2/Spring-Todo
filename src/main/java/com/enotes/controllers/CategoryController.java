package com.enotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.controllers.apicontroller.CategoryApi;
import com.enotes.services.CategoryService;
import com.enotes.services.TodoService;

import dto.CategoryDto;
import dto.TodoDto;

import java.util.List;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController implements CategoryApi {
    
	    @Autowired
	    private TodoService todoService;

	    @Autowired
	    private CategoryService categoryService;
	
	@Override
	public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		 return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<CategoryDto> updateCategory(CategoryDto user) {
		// TODO Auto-generated method stub
        return new ResponseEntity<>(categoryService.save(user), HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		// TODO Auto-generated method stub
		 return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(Long id) {
		// TODO Auto-generated method stub
        return new ResponseEntity<>(todoService.findByCategory(id), HttpStatus.OK);
 
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(Long id) {
		// TODO Auto-generated method stub
        return new ResponseEntity<>(categoryService.findAllByUserId(id), HttpStatus.OK);
 
	}

	@Override
	public ResponseEntity<CategoryDto> getCategory(Long id) {
		// TODO Auto-generated method stub
		  return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteCategory(Long id) {
		// TODO Auto-generated method stub
		 categoryService.delete(id);
	        return new ResponseEntity(HttpStatus.OK);
	}

	
    
	
    
 
    
    
    

}
