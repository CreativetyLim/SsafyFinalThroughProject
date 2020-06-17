package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/map")
public class MapController {
	
	@GetMapping("/test")
	public String map() {
		return "location";
	}
}
