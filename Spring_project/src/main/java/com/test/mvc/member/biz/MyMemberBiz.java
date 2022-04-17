package com.test.mvc.member.biz;

import java.util.List;
import java.util.Map;

import com.test.mvc.member.dto.MyMemberDto;

public interface MyMemberBiz {

	
	//관리자 
	//1. 유저 전체 조회(탈퇴 회원 포함 )
	//2. 가입상태인 유저만 조회 (enabled y인 회원만 )
	//3. 등급 조정(admin<->user)
	
	public List<MyMemberDto> selectAll();
	public List<MyMemberDto> selectEn();
	public int roleUpdate(MyMemberDto dto);
	
	//user
	//1. 로그인  
	//3. 회원가입 <-2. 아이디 중복체크
	//4. 내정보 조회
	//5. 내정보수정
	//6.회원탈퇴( enabled update해서 n을 바꾸자 )
	
	public MyMemberDto login(MyMemberDto dto);
	public int regist(MyMemberDto dto);
	//public boolean idChk(); -> 다하고 추가 하자 
	public MyMemberDto myInfo(int member_seq);
	public int myInfoUpdate(Map<String, Object> map);
	public int dropId(MyMemberDto dto);
	
	
}
