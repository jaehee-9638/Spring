package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.MyOrderDto;

public interface MyOrderBiz {
	
	public List<MyOrderDto> myOrderSelectList();
	public MyOrderDto myOrderSelectOne(int orderSeq);
	public int myOrderInsert(MyOrderDto dto);
	public int myOrderUpdate(MyOrderDto dto);
	public int myOrderDelete(int orderSeq);

}
