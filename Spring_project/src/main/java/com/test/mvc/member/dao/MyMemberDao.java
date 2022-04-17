package com.test.mvc.member.dao;

import java.util.List;
import java.util.Map;

import com.test.mvc.member.dto.MyMemberDto;

public interface MyMemberDao {
	String NAMESPACE="mymember.";
	
	public List<MyMemberDto> selectAll();
	public List<MyMemberDto> selectEn();
	public int roleUpdate(MyMemberDto dto);
	
	
	public MyMemberDto login(MyMemberDto dto);
	public int regist(MyMemberDto dto);
	//public boolean idChk(); -> 다하고 추가 하자 
	public MyMemberDto myInfo(int member_seq);
	public int myInfoUpdate(Map<String, Object> map);
	public int dropId(MyMemberDto dto);
	
}
