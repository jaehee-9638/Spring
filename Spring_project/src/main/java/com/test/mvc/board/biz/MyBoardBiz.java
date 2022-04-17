package com.test.mvc.board.biz;

import java.util.List;

import com.test.mvc.board.dto.MyBoardDto;

public interface MyBoardBiz {
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int board_seq);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int board_seq);
	//조회수
	public int viewCount(int board_seq);
	//트랜잭션
	public String test();
	//게시글 총갯수
	public int count();
	public List<MyBoardDto> selectListPage(int start_num);
	
}
