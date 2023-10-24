package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.IBoardDao;
import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ReplyDto;

@Service
public class BoardSericeImple implements IBoardService{
	
	@Autowired
	IBoardDao boardDao;
	
	//리스트 목록보기
	public List<BoardDto> showList(){
		return boardDao.list();
	}
	
	//게시글 작성
	public int write(String board_name, String board_title, String board_content) {
		int result = boardDao.write(board_name, board_title, board_content);
		 
		return result;
	}
	
	//글 내용 조회
	public BoardDto viewDto(String board_idx) {
		return boardDao.viewDto(board_idx);
		
	}
	
	//게시글 삭제
	public int delete(String board_idx) {
		int result = boardDao.delete(board_idx);
		return result;
	}
	
	//게시글 수정
	public int updateboard(String board_idx, String board_name, String board_title, String board_content, String board_hit) {
		int result = 0;
		result = boardDao.updateboard(board_idx, board_name, board_title, board_content, board_hit);
		if(result == 1) {
			System.out.println("글 수정 성공");
			return result;
		}
		else {
			System.out.println("글 수정 실패");
			return result;
		}
	}
	//조회수 증가
	public int hit(String board_idx) {
		int result = 0;
		result = boardDao.hit(board_idx);
		return result;
	}
	
	//게시판 글별 댓글 리스트 조회
	public List<ReplyDto> reply_list(String reply_board_idx){
		return boardDao.reply_list(reply_board_idx);
	}
	
	//댓글 달기
	public int replyWrite(String reply_name, String reply_content, String board_idx) {
		int result = 0;
		result = boardDao.replyWrite(reply_name, reply_content, board_idx);
		if(result == 1) {
			System.out.println("댓글 등록 성공");
			return result;
		}
		else {
			System.out.println("댓글 등록 실패");
			return result;
		}
	}
	
	//댓글 삭제
//	boardSericeImple.deleteReply(reply_idx);
	public int deleteReply(String reply_idx) {
		int result = 0;
		result = boardDao.deleteReply(reply_idx);
		if(result == 1) {
			System.out.println("댓글 삭제 성공");
			return result;
		}else {
			System.out.println("댓글 삭제 실패");
			return result;
		}
	}
	
}
