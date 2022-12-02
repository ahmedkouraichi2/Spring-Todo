package com.enotes.services.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enotes.UserValidator.TodoValidator;
import com.enotes.entity.Category;
import com.enotes.entity.Todo;
import com.enotes.exception.EntityNotFoundException;
import com.enotes.exception.ErrorCodes;
import com.enotes.exception.InvalidEntityException;
import com.enotes.repository.CategoryRepository;
import com.enotes.repository.TodoRepository;
import com.enotes.services.TodoService;

import dto.CategoryDto;
import dto.TodoDto;
@Service
public class TodoServiceImpl  implements TodoService{
	
	 @Autowired
	 private TodoRepository todoRepository;
	 
	 @Autowired 
	 
	 private CategoryRepository  categoryRepository;

	@Override
	public TodoDto save(TodoDto todoDto) {
		
		List<String> errors= TodoValidator.validateTodo(todoDto);
		if(!errors.isEmpty()) {
		  System.out.print("Todo is not valid {}");
		  throw new InvalidEntityException("Todo is not valid",ErrorCodes.TODO_NOT_VALID,errors);
		  
		}
		
		return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(todoDto)));
		
	}

	@Override
	public List<TodoDto> findAll() {
		return todoRepository.findAll().stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public TodoDto findById(Long id) {
     if(id ==null) {
    	  System.out.println("USER id is null");
    	  return null;
     }
     
     final Long categoryId = categoryRepository.findCategoryByTodoId(id);
     Category category = new Category();
     category.setId(categoryId);
		
      final Optional<Todo> todo = todoRepository.findById(id);
      todo.ifPresent(value -> value.setCategory(category));
      
      final TodoDto todoDto = TodoDto.fromEntity(todo.get());
      CategoryDto  categoryDto =  CategoryDto.fromEntity(category);
      todoDto.setCategory(categoryDto);
      
      return Optional.of(todoDto).
    		  orElseThrow(( )->
    		      new EntityNotFoundException("No Todo found with id = "+ id, ErrorCodes.TODO_NOT_FOUND));
    				  
      
	}

	@Override
	public List<TodoDto> findByCategory(Long categoryId) {
		 
		return todoRepository.findTodoByCategoryId(categoryId).stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
				
			
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			 System.out.println("toDo is is null");
			 return ;
		}
		
		todoRepository.deleteById(id);	
	}

}
