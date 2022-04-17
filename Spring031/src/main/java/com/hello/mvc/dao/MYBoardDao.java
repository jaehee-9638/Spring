package com.hello.mvc.dao;

import java.util.List;

import com.hello.mvc.dto.MYBoardDto;

public interface MYBoardDao {

	String NAMESPACE="myboard-mapper.";
	
	public List<MYBoardDto> selectList();
	public MYBoardDto selectOne(int myno);
	public int insert(MYBoardDto dto);
	public int update(MYBoardDto dto);
	public int delete(int myno);
	
}
