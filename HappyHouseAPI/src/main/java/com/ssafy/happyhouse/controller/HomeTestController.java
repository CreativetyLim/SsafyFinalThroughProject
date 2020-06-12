package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/qna")
public class HomeTestController {
	
	@GetMapping("/")
	public String in() {
		return "index";
	}
	
}
