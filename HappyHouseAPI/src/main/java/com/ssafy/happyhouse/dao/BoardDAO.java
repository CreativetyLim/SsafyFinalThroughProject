package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Board;

@Mapper
public interface BoardDAO {
	
	List<Board> selectBoard();

	int regist(Board board);
	public int update(Board board);
	public int delete(Integer board_no);
	public List<Board> selectOne(String search);
}
