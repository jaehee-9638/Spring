package com.test.mv.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mv.dto.MyMemberDto;
@Repository("MyMemberDaoImpl")
public class MyMemberDaoImpl implements MyMemberDao {

	@Autowired(required = true)
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyMemberDto> selectList() {
		//Sqlsession =session.getSqlSessionFactory().openSession();
		List<MyMemberDto> list = new ArrayList<MyMemberDto>();
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return list;
	}

}
