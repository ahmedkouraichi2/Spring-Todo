package com.enotes.controllers;

import java.util.List;

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

import dto.TodoDto;

@RestController
@RequestMapping("todos")
@CrossOrigin(origins = "*")
public class TodoController {
	
	   @Autowired
	   private TodoService todoService;
 
	   @Autowired
	   private CategoryService categoryService;
	 
   
	   @PostMapping("/addTodo") 
	   public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto userDto) {
        return new ResponseEntity<>(todoService.save(userDto), HttpStatus.CREATED);
    }
	
	    @PutMapping("/modifierTodo/{id}")
	   public ResponseEntity<TodoDto> updateTodo( @RequestBody TodoDto todoDto) {
	        return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
	    }
	   
	   @GetMapping("/todos/create")
	   public ResponseEntity<List<TodoDto>> getAllTodos() {
	        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
	    }
	   
	   
	   
	   @DeleteMapping("todos/delete/{id}")
	   public  ResponseEntity 
	   deleteTodo(@PathVariable Long id) {
	         todoService.delete(id);	
	         return new ResponseEntity(HttpStatus.OK);
	         
	   }
	 	

}
