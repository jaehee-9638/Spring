package com.hello.mvc.dao;

import com.hello.mvc.dto.MYMemberDto;

public interface MYMemberDao {
	
	String NAMESPACE ="mymember.";
	public MYMemberDto login(MYMemberDto dto);
}
