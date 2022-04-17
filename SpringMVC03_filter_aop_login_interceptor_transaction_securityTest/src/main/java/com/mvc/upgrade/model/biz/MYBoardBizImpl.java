package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.MYBoardDao;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Service
public class MYBoardBizImpl implements MYBoardBiz {

	@Autowired
	private MYBoardDao dao;
	
	@Override
	public List<MYBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MYBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MYBoardDto dto) {
	
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		
		return dao.delete(myno);
	}

	//@Transactional
	//두번재 꺼가 실패하면 첫번째 진행했떤것도 무효회하게 하는 어노테이션 
	@Override
	public String test() {
		dao.insert(new MYBoardDto(0,"test","transaction test","transaction이 뭐였지????",null));
		
		String test=dao.test();
		//dao2개 호출했음 ,,하나의 기능에 두개의 쿼리가 하나처럼 동작하겠단 소리 :트렌젝션 
		//지금 메소드에 걸엇찌만 클래스에도 걸수있ㄷ응 ㅁ
		test.length();
		
		return null;
	}

}








