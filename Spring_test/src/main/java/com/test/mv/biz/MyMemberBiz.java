package com.test.mv.biz;

import java.util.List;

import com.test.mv.dto.MyMemberDto;

public interface MyMemberBiz {
	
	public List<MyMemberDto> selectList();
}
