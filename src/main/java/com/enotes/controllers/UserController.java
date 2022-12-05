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

import com.enotes.services.UserService;

import dto.UserDto;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	
	  @Autowired
	    private UserService userService;
	  
	  
	   @PostMapping("/users/create")
	   /*"Creates a new user " */
	  public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
	       return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	  }
	  
	  /*  "Updates an existing user "    */ 
	  
	   @PutMapping("/users/{id}")
	   public ResponseEntity<UserDto> updateUser( @PathVariable Long id, @RequestBody UserDto user) {
	        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	    }
	  
	  

	  
	  @GetMapping("/users/all")
	    public ResponseEntity<List<UserDto>> getAllUsers() {
	        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	    }
	  
	  
	    @GetMapping("/users/{id}")
	    public ResponseEntity<UserDto> getUser( @PathVariable Long id) {
	        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	    }
	  
	    @DeleteMapping("/users/delete/{id}")
	    public ResponseEntity deleteUser( @PathVariable Long id) {
	        userService.delete(id);
	        return new ResponseEntity(HttpStatus.OK);
	    }
	  


}
