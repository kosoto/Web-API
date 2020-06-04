package com.rest.api.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCtrl {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}
}
