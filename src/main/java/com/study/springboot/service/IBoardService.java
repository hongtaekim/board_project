package com.study.springboot.service;

import java.util.List;


import com.study.springboot.dto.BoardDto;


public interface IBoardService {

	//글 목록 보기
	public abstract List<BoardDto> showList();
	
	//글 작성하기
	public abstract int write(String board_name, String board_title, String board_content);
	
	//글 내용 조회
	public abstract BoardDto viewDto(String board_idx);
	
	//게시글 삭제
	public abstract int delete(String board_idx);
}
