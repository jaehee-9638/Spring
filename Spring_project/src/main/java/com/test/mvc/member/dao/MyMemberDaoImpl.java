package com.test.mvc.member.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mvc.member.dto.MyMemberDto;
@Repository
public class MyMemberDaoImpl implements MyMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyMemberDto> selectAll() {
		List<MyMemberDto> list = new ArrayList<MyMemberDto>();
		try {
			list =sqlSession.selectList(NAMESPACE+"userAll");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<MyMemberDto> selectEn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int roleUpdate(MyMemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public MyMemberDto login(MyMemberDto dto) {
		MyMemberDto res=null;
		try {
			res=sqlSession.selectOne(NAMESPACE+"login", dto);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}

	@Override
	public int regist(MyMemberDto dto) {
		System.out.println("3");
		int res=0;
		try {
			System.out.println("4");
			res=sqlSession.insert(NAMESPACE+"regist", dto);
			System.out.println("dao에서 res"+res);
		} catch (Exception e) {
			System.out.println("5");
			// TODO: handle exception
		}

		return res;
	}

	@Override
	public MyMemberDto myInfo(int member_seq) {
		MyMemberDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"myInfo", member_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public int myInfoUpdate(Map<String, Object> map) {
		int res =0;
		System.out.println("컨트롤러 에서 map"+map.size());	//얘 왜 1이지
		try {
			res=sqlSession.update(NAMESPACE+"myInfoUpdate", map);
			System.out.println("컨트롤러에서 res"+res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public int dropId(MyMemberDto dto) {
		int res =0;
		try {
			
			res=sqlSession.update(NAMESPACE+"dropId", dto);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

}
