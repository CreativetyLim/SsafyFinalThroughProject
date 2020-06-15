package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Board;

public interface BoardService {
	List<Board> retrieveboard();
	int regist(String board_userid,String board_title,String board_content);
	public int update(int no,String board_userid,String board_title,String board_content);
	public int delete(int no);
	public List<Board> selectOne(String search);
	public List<Board> selectAll();
}
