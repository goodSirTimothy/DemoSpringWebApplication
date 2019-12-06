package com.revature.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.service.DarkModeService;
import com.revature.service.DarkModeServiceImpl;

@Controller
public class DarkModeController {
	private static final DarkModeService darkModeService = new DarkModeServiceImpl();
	
	private DarkModeController() {
	}

	@GetMapping(value="/enable-dark-mode")
	public String enableDarkMode(Principal principal, Model model) {
		darkModeService.enableDarkMode();
		return "redirect:/todos";
	}
}
