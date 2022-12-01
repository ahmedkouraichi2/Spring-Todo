package com.enotes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoHeloo {
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

}
