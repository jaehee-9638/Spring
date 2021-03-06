package com.test.mvc.board.dao;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.TableModel;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mvc.board.dto.MyBoardDto;
@Repository
public class MyBoardDaoImpl implements MyBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyBoardDto> selectList() {
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public MyBoardDto selectOne(int board_seq) {
		MyBoardDto dto=null;
		try {
			dto= sqlSession.selectOne(NAMESPACE+"selectOne", board_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public int insert(MyBoardDto dto) {
		int res=0;
		System.out.println("dao까지는오느ㅏ?");
		try {
			res=sqlSession.insert(NAMESPACE+"insert", dto);
			System.out.println("트라이캐치문 오류?"+res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("dao에서 나가기전 res"+res);
		return res;
	}

	@Override
	public int update(MyBoardDto dto) {
		int res=0;
		try {
			res=sqlSession.update(NAMESPACE+"update", dto);
			System.out.println("dao에서 update"+res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public int delete(int board_seq) {
		int res=0;
		try {
			res=sqlSession.delete(NAMESPACE+"delete", board_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int viewCount(int board_seq) {
		int res =0;
		try {
			res=sqlSession.update(NAMESPACE+"viewCount", board_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public int count() {
		int res=0;
		try {
			res=sqlSession.selectOne(NAMESPACE+"paging");
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("dao에서 리턴될 res="+res);
		return res;
	}

	@Override
	public List<MyBoardDto> selectListPage(int start_num) {
		System.out.println("dao들어옴");
		System.out.println("dao param1:"+start_num);
		
	
		List<MyBoardDto> list=new ArrayList<MyBoardDto>();
		try {
			list=sqlSession.selectList(NAMESPACE+"selectListPage",start_num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println("dao에서 리턴될 selectListPage="+list);	//지금 비어있는 배열임
		

		
		//selectListPage
		return list;
	}

	
	

}
