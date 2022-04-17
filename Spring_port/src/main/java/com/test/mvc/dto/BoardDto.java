package com.test.mvc.dto;

import java.util.Date;

public class BoardDto {
	private int Board_seq;
	private String Board_id;
	private String Board_title;
	private String Board_content;
	private Date Board_regdate;
	private int Board_read;
	private String Board_pw;
	public BoardDto() {
	
	}
	public BoardDto(int board_seq, String board_id, String board_title, String board_content, Date board_regdate,
			int board_read, String board_pw) {
	
		Board_seq = board_seq;
		Board_id = board_id;
		Board_title = board_title;
		Board_content = board_content;
		Board_regdate = board_regdate;
		Board_read = board_read;
		Board_pw = board_pw;
	}
	public int getBoard_seq() {
		return Board_seq;
	}
	public void setBoard_seq(int board_seq) {
		Board_seq = board_seq;
	}
	public String getBoard_id() {
		return Board_id;
	}
	public void setBoard_id(String board_id) {
		Board_id = board_id;
	}
	public String getBoard_title() {
		return Board_title;
	}
	public void setBoard_title(String board_title) {
		Board_title = board_title;
	}
	public String getBoard_content() {
		return Board_content;
	}
	public void setBoard_content(String board_content) {
		Board_content = board_content;
	}
	public Date getBoard_regdate() {
		return Board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		Board_regdate = board_regdate;
	}
	public int getBoard_read() {
		return Board_read;
	}
	public void setBoard_read(int board_read) {
		Board_read = board_read;
	}
	public String getBoard_pw() {
		return Board_pw;
	}
	public void setBoard_pw(String board_pw) {
		Board_pw = board_pw;
	}
	
}
