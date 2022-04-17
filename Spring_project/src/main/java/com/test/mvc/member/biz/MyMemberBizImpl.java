package com.test.mvc.member.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mvc.member.dao.MyMemberDao;
import com.test.mvc.member.dto.MyMemberDto;
@Service
public class MyMemberBizImpl implements MyMemberBiz {

	@Autowired
	private MyMemberDao dao;
	
	@Override
	public List<MyMemberDto> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<MyMemberDto> selectEn() {
		return dao.selectEn();
	}

	@Override
	public int roleUpdate(MyMemberDto dto) {
		return dao.roleUpdate(dto);
	}

	@Override
	public MyMemberDto login(MyMemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public int regist(MyMemberDto dto) {
		return dao.regist(dto);
	}

	@Override
	public MyMemberDto myInfo(int member_seq) {
		return dao.myInfo(member_seq);
	}

	@Override
	public int myInfoUpdate(Map<String, Object> map) {
		return dao.myInfoUpdate(map);
	}

	@Override
	public int dropId(MyMemberDto dto) {
		return dao.dropId(dto);
	}

}
