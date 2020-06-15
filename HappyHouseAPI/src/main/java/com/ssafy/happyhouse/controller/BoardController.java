package com.ssafy.happyhouse.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Board;
import com.ssafy.happyhouse.service.BoardService;

import io.swagger.annotations.ApiOperation;
//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/board")
public class BoardController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

///////////////////////////////////////게시물 관련 ///////////////////////////////////////////////////////	
	// 전체 게시물 보기
    @ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping("/selectAll")
	public List<Board> retrieveBoard() throws Exception {
		return boardService.selectAll();
	}
    
    // 게시물 등록
    @PostMapping("/registBoard")
    public int registBoard(String board_userid,String board_title,String board_content) throws Exception{
    	int result = boardService.regist(board_userid,board_title,board_content);
    	
    	return result;
    }
    
    
    // 게시물 수정
    @PutMapping("/editBoard")
    public int editBoard(int board_no,String board_userid,String board_title,String board_content) throws Exception{
    	int result = boardService.update(board_no, board_userid, board_title, board_content);
    	
    	return result;
    }
    
    //게시물 삭제
    @DeleteMapping("/deleteBoard")
    
    public int deleteBoard(int board_no) throws Exception{
    	int delete = boardService.delete(board_no);
    	
    	return delete;
    }
    
    
    // 게시물 검색
    @GetMapping("/searchBoard")
    public List<Board> SearchBoard(String search) throws Exception{
    	
    	return boardService.selectOne(search);
    }
    
 
    
}
