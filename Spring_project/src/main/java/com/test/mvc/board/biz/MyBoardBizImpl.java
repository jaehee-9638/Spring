package com.test.mvc.board.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mvc.board.dao.MyBoardDao;
import com.test.mvc.board.dto.MyBoardDto;
@Service
public class MyBoardBizImpl implements MyBoardBiz {

	@Autowired
	private MyBoardDao dao;
	
	@Override
	public List<MyBoardDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public MyBoardDto selectOne(int board_seq) {
		return dao.selectOne(board_seq);
	}

	@Override
	public int insert(MyBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MyBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int board_seq) {
		return dao.delete(board_seq);
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int viewCount(int board_seq) {
		// TODO Auto-generated method stub
		return dao.viewCount(board_seq);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public List<MyBoardDto> selectListPage(int start_num) {
		// TODO Auto-generated method stub
		System.out.println("biz까지 옴?");
		return dao.selectListPage(start_num);
	}

	

}
