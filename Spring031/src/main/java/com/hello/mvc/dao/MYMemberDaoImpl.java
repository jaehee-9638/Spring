package com.hello.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.mvc.dto.MYMemberDto;
@Repository
public class MYMemberDaoImpl implements MYMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MYMemberDto login(MYMemberDto dto) {
		//여기서 crud 해주는거자너 ... 그럼 쿼리는 매퍼 만들고거 얘는 그냥 세션에 값 넣어서 출력이나 하자궁 ...
		MYMemberDto res=null;
		try {
			res=sqlSession.selectOne(NAMESPACE+"login", dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return res;
	}

}
