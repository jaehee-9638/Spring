package com.test.mvc.dao;

import java.util.List;

import com.test.mvc.dto.BoardDto;

public interface BoardDao {

	public List<BoardDto> selectList();
	public BoardDto selectOne(int seq);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int seq);
}
