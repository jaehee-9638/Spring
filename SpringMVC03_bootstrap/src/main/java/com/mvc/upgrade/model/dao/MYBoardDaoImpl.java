package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MYBoardDto;

@Repository
public class MYBoardDaoImpl implements MYBoardDao {
	//외부IO처리 :DAO같은 보통 데이터베이스와 관련된 클래스에

	@Autowired	//각상황의 타입에 맞는 ioc컨테이너 안에 존재하는 bean을 자동으로 주입해주게 된다. 
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<MYBoardDto> selectList() {
		
		List<MYBoardDto >list=new ArrayList<MYBoardDto>();
		
		try {
			list=sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		MYBoardDto dto=null;
		
		try {
		dto=sqlSession.selectOne(NAMESPACE+"selectOne",myno);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(MYBoardDto dto) {
		
		int res=0;
		try {
		res=sqlSession.insert(NAMESPACE+"insert",dto);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(MYBoardDto dto) {
		int res=0;
		try {
			res=sqlSession.update(NAMESPACE+"update",dto);
			}catch (Exception e) {
				e.printStackTrace();
			}
		return res;
	}

	@Override
	public int delete(int myno) {

		int res=0;
		try {
			res=sqlSession.delete(NAMESPACE+"delete",myno);
			}catch (Exception e) {
				e.printStackTrace();
			}
		return res;
	}

}
