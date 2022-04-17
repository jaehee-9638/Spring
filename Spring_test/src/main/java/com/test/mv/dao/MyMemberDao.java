package com.test.mv.dao;

import java.util.List;

import com.test.mv.dto.MyMemberDto;

public interface MyMemberDao {
	
	String NAMESPACE="mymember.mapper.";
	
	public List<MyMemberDto> selectList();
	
	
}
