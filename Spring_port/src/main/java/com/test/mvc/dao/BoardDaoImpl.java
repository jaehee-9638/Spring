package com.test.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mvc.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao  {
	@Autowired
	 String NAMESPACE="boardmapper.";
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<BoardDto> selectList() {
		
		return null;
	}

	@Override
	public BoardDto selectOne(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
