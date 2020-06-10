package com.ssafy.happyhouse.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.service.QnAService;

import io.swagger.annotations.ApiOperation;
//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/qna")
public class QnAController {
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private QnAService qnaService;
	
	
///////////////////////////////////////게시물 관련 ///////////////////////////////////////////////////////	
	// 전체 게시물 보기
    @ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping("/selectAll")
	public ResponseEntity<List<QnA>> retrieveBoard() throws Exception {
		logger.debug("retrieveBoard - 호출");
		return new ResponseEntity<List<QnA>>(qnaService.retrieveQnA(), HttpStatus.OK);
	}
    
    // 게시물 등록
    @PostMapping("/registBoard")
    public int registBoard(String qna_userid,String qna_title,String qna_content) throws Exception{
    	System.out.println("qna_userid"+qna_userid);
    	int result = qnaService.regist(qna_userid,qna_title,qna_content);
    	
    	return result;
    }
    
    
    // 게시물 수정
    @PutMapping("/editBoard")
    public int editBoard(int qna_no,String qna_userid,String qna_title,String qna_content) throws Exception{
    	int result = qnaService.update(qna_no, qna_userid, qna_title, qna_content);
    	
    	return result;
    }
    
    //게시물 삭제
    @DeleteMapping("/deleteBoard")
    public int deleteBoard(int qna_no) throws Exception{
    	System.out.println("qua_no" + qna_no);
    	int delete = qnaService.delete(qna_no);
    	
    	return delete;
    }
    
    
    // 게시물 검색
    @GetMapping("/searchBoard")
    public ResponseEntity<List<QnA>> searchBoard(String search) throws Exception{
    	
    	return new ResponseEntity<List<QnA>>(qnaService.selectOne(search),HttpStatus.OK);
    }
    
 /////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////댓글 관련 ///////////////////////////////////////////////////////////
    
 // 댓글 등록
    @PostMapping("/registReply")
    public int registReply(int qna_no,String reply_userid,String reply_content) throws Exception{
    	int result = qnaService.registReply(qna_no,reply_userid,reply_content);
    	
    	return result;
    }
    
    
    //댓글 삭제
    @DeleteMapping("/deleteReply")
    public int deleteReply(int qna_no) throws Exception{
    	int delete = qnaService.deleteReply(qna_no);
    	
    	return delete;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
}
