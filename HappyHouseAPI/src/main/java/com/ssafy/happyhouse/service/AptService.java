package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDeal;

public interface AptService {

	List<HouseDeal> selectAll();
	List<HouseDeal> selectOne(String s);
	
}
