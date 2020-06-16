package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HomeTestController {
	
	@GetMapping("/home")
	public String in() {
		System.out.println("hi");
		return "direction";
	}
	
}
