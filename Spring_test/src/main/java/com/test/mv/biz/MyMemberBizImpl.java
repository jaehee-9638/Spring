package com.test.mv.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mv.dao.MyMemberDao;
import com.test.mv.dto.MyMemberDto;
@Service("MyMemberBizImpl")
public class MyMemberBizImpl implements MyMemberBiz {

	@Autowired(required = true)
	private MyMemberDao dao;
	
	@Override
	public List<MyMemberDto> selectList() {
		
		return dao.selectList();
	}

}
