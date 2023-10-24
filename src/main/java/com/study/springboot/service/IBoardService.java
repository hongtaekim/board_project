package com.study.springboot.service;

import java.util.List;


import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ReplyDto;


public interface IBoardService {

	//글 목록 보기
	public abstract List<BoardDto> showList();
	
	//글 작성하기
	public abstract int write(String board_name, String board_title, String board_content);
	
	//글 내용 조회
	public abstract BoardDto viewDto(String board_idx);
	
	//게시글 삭제
	public abstract int delete(String board_idx);
	
	//게시긇 수정
	public abstract int updateboard(String board_idx, String board_name, String board_title, String board_content, String board_hit);
	
	//조회수 증가
	public abstract int hit(String board_idx);

	//글목록별 댓글 조회
	public abstract List<ReplyDto> reply_list(String reply_board_idx);
	
	//댓글 달기
	public abstract int replyWrite(String reply_name, String reply_content, String board_idx);
	
	//댓글 삭제
	public int deleteReply(String reply_idx);
}
