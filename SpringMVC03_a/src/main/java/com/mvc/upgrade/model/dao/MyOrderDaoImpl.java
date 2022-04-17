package com.mvc.upgrade.model.dao;

import java.util.ArrayList;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mvc.upgrade.model.dto.MyOrderDto;

@Repository
public class MyOrderDaoImpl implements MyOrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MyOrderDto> myOrderSelectList() {
		List<MyOrderDto>list=new ArrayList<MyOrderDto>();
		
		
		try {
			list=sqlSession.selectList(NAMESPACE+"myOrderSelectList");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return list;
	}

	@Override
	public MyOrderDto myOrderSelectOne(int orderSeq) {
		MyOrderDto dto=null;
		
		try {
		dto=sqlSession.selectOne(NAMESPACE+"myOrderSelectOne",orderSeq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int myOrderInsert(MyOrderDto dto) {
		int res=0;
		try {
		res=sqlSession.insert(NAMESPACE+"myOrderInsert",dto);
	}catch (Exception e) {
		e.printStackTrace();
	}
		
		return res;
	}

	@Override
	public int myOrderUpdate(MyOrderDto dto) {
		int res=0;
		try {
			res=sqlSession.update(NAMESPACE+"myOrderUpdate",dto);
			}catch (Exception e) {
				e.printStackTrace();
			}
		return res;
	}

	@Override
	public int myOrderDelete(int orderSeq) {
		int res=0;
		try {
			res=sqlSession.delete(NAMESPACE+"myOrderDelete",orderSeq);
			}catch (Exception e) {
				e.printStackTrace();
			}
		return res;
	}

}
