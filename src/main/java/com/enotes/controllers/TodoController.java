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

import com.enotes.controllers.apicontroller.TodoApi;
import com.enotes.services.CategoryService;
import com.enotes.services.TodoService;

import dto.TodoDto;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController implements   TodoApi  {
	
	@Autowired
    private TodoService todoService;

    @Autowired
    private CategoryService categoryService;
    

	@Override
	public ResponseEntity<TodoDto> createTodo(TodoDto todoDto) {
		// TODO Auto-generated method stub
		 return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TodoDto> updateTodo(TodoDto todo) {
	
		 return new ResponseEntity<>(todoService.save(todo), HttpStatus.CREATED); 
		 
	}
	@Override
	public ResponseEntity<List<TodoDto>> getAllTodos() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<TodoDto> getTodo(Long todoId) {
		// TODO Auto-generated method stub
		 return  new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteTodo(Long id) {
		// TODO Auto-generated method stub
	    todoService.delete(id);
	    return null;
	}
	
	  
	

}
