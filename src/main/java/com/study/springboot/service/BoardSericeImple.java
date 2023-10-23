package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.IBoardDao;
import com.study.springboot.dto.BoardDto;

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
}
