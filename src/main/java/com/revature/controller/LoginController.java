package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	private LoginController() {
	}
	
	@GetMapping(value="/login")
	public String showLoginPage() {
		return "login";
	}

}
