package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.BoardDAO;
import com.ssafy.happyhouse.dto.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;
	Board board;
	
	@Override
	public List<Board> retrieveboard() {
		return dao.selectBoard();
	}
	@Override
	public int regist(String board_userid,String board_title,String board_content) {
		// TODO Auto-generated method stub
		board= new Board();
		board.setBoardUserid(board_userid);
		board.setBoardTitle(board_title);
		board.setBoardContent(board_content);
		return dao.regist(board);
	}

	@Override
	public int update(int board_no,String board_userid,String board_title,String board_content) {
		board= new Board();
		board.setBoardUserid(board_userid);
		board.setBoardTitle(board_title);
		board.setBoardContent(board_content);
		board.setBoardNo(board_no);
		return dao.update(board);
	}

	@Override
	public int delete(int board_no) {
		return dao.delete(board_no);
	}

	@Override
	public List<Board> selectOne(String search) {
		return dao.selectOne(search);
	}
	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectBoard();
	}
	
}
