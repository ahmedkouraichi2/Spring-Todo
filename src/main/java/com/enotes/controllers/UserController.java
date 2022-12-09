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

import com.enotes.controllers.apicontroller.UserApi;
import com.enotes.services.UserService;

import dto.UserDto;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController implements UserApi {
	
    @Autowired
    private UserService userService ;

	@Override
	public ResponseEntity<UserDto> createUser(UserDto user) {
		// TODO Auto-generated method stub
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
 
	}

	@Override
	public ResponseEntity<UserDto> updateUser(Long id, UserDto user) {
		
		  return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<UserDto>> getAllUsers() {
		// TODO Auto-generated method stub
		 return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> getUser(Long id) {
		// TODO Auto-generated method stub
		 return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	


}
