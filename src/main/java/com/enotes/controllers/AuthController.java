package com.enotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.controllers.apicontroller.AuthApi;
import com.enotes.services.UserService;

import dto.UserDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController  implements AuthApi {

	
	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<UserDto> loginUser(UserDto user) {
		// TODO Auto-generated method stub
		
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);

 	}
 
}
