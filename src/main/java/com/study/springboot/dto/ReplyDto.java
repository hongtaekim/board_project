package com.study.springboot.dto;
//reply_idx number(4) primary key,
//reply_name varchar2(20),
//reply_content varchar2(300),
//reply_date date default sysdate,
//reply_board_idx number(4)

import java.util.Date;

import lombok.Data;

@Data
public class ReplyDto {
	private int reply_idx;
	private String reply_name;
	private String reply_content;
	private Date reply_date;
	private int reply_board_idx;
	
	public ReplyDto() {}

	public ReplyDto(int reply_idx, String reply_name, String reply_content, Date reply_date, int reply_board_idx) {
		super();
		this.reply_idx = reply_idx;
		this.reply_name = reply_name;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.reply_board_idx = reply_board_idx;
	}
	
	
}
