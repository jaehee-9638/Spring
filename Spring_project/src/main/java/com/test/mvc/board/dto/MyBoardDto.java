package com.test.mvc.board.dto;

import java.util.Date;

public class MyBoardDto {
	private int board_seq;
	private String board_id;
	private String board_title;
	private String board_content;
	private Date board_regdate;
	private int board_read;
	private String board_pw;
	private String board_thumbimg;
	private String board_gdsimg;
	public MyBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyBoardDto(int board_seq, String board_id, String board_title, String board_content, Date board_regdate,
			int board_read, String board_pw, String board_thumbimg, String board_gdsimg) {
		super();
		this.board_seq = board_seq;
		this.board_id = board_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regdate = board_regdate;
		this.board_read = board_read;
		this.board_pw = board_pw;
		this.board_thumbimg = board_thumbimg;
		this.board_gdsimg = board_gdsimg;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}
	public int getBoard_read() {
		return board_read;
	}
	public void setBoard_read(int board_read) {
		this.board_read = board_read;
	}
	public String getBoard_pw() {
		return board_pw;
	}
	public void setBoard_pw(String board_pw) {
		this.board_pw = board_pw;
	}
	public String getBoard_thumbimg() {
		return board_thumbimg;
	}
	public void setBoard_thumbimg(String board_thumbimg) {
		this.board_thumbimg = board_thumbimg;
	}
	public String getBoard_gdsimg() {
		return board_gdsimg;
	}
	public void setBoard_gdsimg(String board_gdsimg) {
		this.board_gdsimg = board_gdsimg;
	}
	
	
	
}
