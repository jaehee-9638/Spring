package com.test.mvc.biz;

import java.util.List;

import com.test.mvc.dto.BoardDto;

public interface BoardBiz {

	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int seq);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int seq);
}
