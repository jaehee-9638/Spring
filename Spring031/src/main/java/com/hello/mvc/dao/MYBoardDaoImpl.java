package com.hello.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.mvc.dto.MYBoardDto;
@Repository
public class MYBoardDaoImpl implements MYBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	//결과를 출력해야하는곳임 
	@Override
	public List<MYBoardDto> selectList() {
		List<MYBoardDto> list = new ArrayList<MYBoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		MYBoardDto dto = null;
		try {
			dto=sqlSession.selectOne(NAMESPACE+"selectOne", myno);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public int insert(MYBoardDto dto) {
		int res =0;
		try {
			res=sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}

	@Override
	public int update(MYBoardDto dto) {
		int res = 0;
		try {
			res=sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("dao에서의 update:"+res);
		return res;
	}

	@Override
	public int delete(int myno) {
		int res=0;
		try {
			res=sqlSession.delete(NAMESPACE+"delete", myno);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	

}
