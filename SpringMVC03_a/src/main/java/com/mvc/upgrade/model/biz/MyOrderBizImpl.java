package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MyOrderDao;
import com.mvc.upgrade.model.dto.MyOrderDto;
@Service
public class MyOrderBizImpl implements MyOrderBiz {
	
	@Autowired
	private MyOrderDao dao;
	

	@Override
	public List<MyOrderDto> myOrderSelectList() {
		
		return dao.myOrderSelectList();
	}

	@Override
	public MyOrderDto myOrderSelectOne(int orderSeq) {
		
		return dao.myOrderSelectOne(orderSeq);
	}

	@Override
	public int myOrderInsert(MyOrderDto dto) {
		
		return dao.myOrderInsert(dto);
	}

	@Override
	public int myOrderUpdate(MyOrderDto dto) {
		
		return dao.myOrderUpdate(dto);
	}

	@Override
	public int myOrderDelete(int orderSeq) {
	
		return dao.myOrderDelete(orderSeq);
	}

}
