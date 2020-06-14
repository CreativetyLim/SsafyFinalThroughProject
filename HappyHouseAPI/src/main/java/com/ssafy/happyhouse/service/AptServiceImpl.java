package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDAO;
import com.ssafy.happyhouse.dto.HouseDeal;

@Service
public class AptServiceImpl implements AptService {
	
	@Autowired
	HouseDAO mapper;
	
	@Override
	public List<HouseDeal> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public List<HouseDeal> selectOne(String s) {
		// TODO Auto-generated method stub
		List<HouseDeal> list = mapper.selectOne(s);
		System.out.println(list.size());
		
		return list;
	}
 
}
