package com.enotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.services.CategoryService;
import com.enotes.services.TodoService;

import dto.CategoryDto;



@RestController
@RequestMapping("categories")

@CrossOrigin(origins ="*", maxAge= 3600)
public class CategoryController {
	
    @Autowired
    private TodoService todoService;

    @Autowired
    private CategoryService categoryService;
	
   
    
    @PostMapping("/categories/create")
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

}

