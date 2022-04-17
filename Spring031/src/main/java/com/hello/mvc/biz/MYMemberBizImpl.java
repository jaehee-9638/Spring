package com.hello.mvc.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc.dao.MYMemberDao;
import com.hello.mvc.dto.MYMemberDto;
@Service
public class MYMemberBizImpl implements MYMemberBiz {

	@Autowired
	private MYMemberDao dao;
	@Override
	public MYMemberDto login(MYMemberDto dto) {
		return dao.login(dto);
		
	}
}
