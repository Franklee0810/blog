package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardservice;
	
	//작성자랑 넘어온 타이틀, 내용 파라미터로 전달 
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardservice.글쓰기(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
 
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardservice.글삭제하기(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) {
		boardservice.글수정하기(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal) {
	  
		
		boardservice.댓글쓰기(principal.getUser(), boardId, reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		boardservice.댓글삭제(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
