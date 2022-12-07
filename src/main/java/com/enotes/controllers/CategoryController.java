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

import com.enotes.services.CategoryService;
import com.enotes.services.TodoService;

import dto.CategoryDto;
import dto.TodoDto;

import java.util.List;

@RestController
@RequestMapping("api/categories")

@CrossOrigin(origins ="*", maxAge= 3600)
public class CategoryController {
	
    @Autowired
    private TodoService todoService;

    @Autowired
    private CategoryService categoryService;
    
    
    /* List of the categories" */
	@GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
	
	
	@PostMapping("/ajouter")
	 public ResponseEntity<CategoryDto> createCategory( @RequestBody CategoryDto categoryDto){
		return new ResponseEntity<>(categoryService.save(categoryDto),HttpStatus.CREATED);	
		
	}
	
	
	
	
	
	
	@PutMapping("/updateCatgogy")
	 public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto){
		 return new ResponseEntity<>(categoryService.save(categoryDto),HttpStatus.CREATED);
		 
	}
	
	/*  "Deletes a category by ID       */
	@DeleteMapping("/deleteCatgogy/{id}")
	   public ResponseEntity deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
        
        
        
        
        
        
        
    }
	
	/* get "Returns the list of the categories of a selected user"*/
	  
	   @GetMapping("/categories/users/{id}")
	  public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(@PathVariable Long userId) {
	        return new ResponseEntity(categoryService.getAllTodoByCategoriesForToday(userId), HttpStatus.OK);
	    }
	
	
	   
	
	
	
    
 
    
    
    

}
