package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.BoardDto;

//인터페이스를 통해서 마이바티스 mapper xml과 연결해준다.
//즉 mapperxml에서 데이터를 가져온다는뜻
@Mapper //mybatis와 연결되어지는 친구라는뜻
public interface IBoardDao {
	public List<BoardDto> list();
	//list로 가져오는 인터페이스 메서드
	
	//insert, update, delete는 리턴값을 int로 받을 수 있다.
	public int write(String board_name, String board_title, String board_content);
	
	//데이터 단건 조회
	public BoardDto viewDto(String board_idx);
	
	//글 삭제
	public int delete(String board_idx);
}
