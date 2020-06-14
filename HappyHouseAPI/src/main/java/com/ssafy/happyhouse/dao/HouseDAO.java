package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDeal;

@Mapper
public interface HouseDAO {
	public List<HouseDeal> selectAll();
	public List<HouseDeal> selectOne(String search);
}
