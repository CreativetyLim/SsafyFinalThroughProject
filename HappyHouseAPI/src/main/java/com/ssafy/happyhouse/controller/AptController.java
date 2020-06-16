package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.service.AptService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/apt")
public class AptController {
	
	@Autowired
	private AptService ser;
	
	
	@GetMapping("/list")
	public List<HouseDeal> list(ModelAndView mv) {
		
		return ser.selectAll();
	}
	
	@GetMapping("/search")
	public List<HouseDeal> search(String word) {
		return ser.selectOne(word);
	}
}
