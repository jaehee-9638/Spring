package com.test.mvc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mvc.dao.BoardDao;
import com.test.mvc.dao.BoardDaoImpl;
import com.test.mvc.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	BoardDao dao = new BoardDaoImpl();
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

}
