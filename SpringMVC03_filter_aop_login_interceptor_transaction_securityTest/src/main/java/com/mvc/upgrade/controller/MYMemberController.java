package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MYMemberBiz;
import com.mvc.upgrade.model.dto.MYMemberDto;

@Controller
public class MYMemberController {

	private Logger logger=LoggerFactory.getLogger(MYMemberController.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[Controller] loginform.do");
		return "mymemberlogin";
		
	}
	/*
	 	@RequestBody:request로 넘어오는 데이터를 java object(객체)로 변환 
	 	@ResponseBody: java object(객체)를 response객체에 데이터로 binding -> 리스판스 바디 갱장히 중요
	 	 	-> 걸어두면 
	 	둘이항상 같이쓰는건아님 따로따로 필요할때 씀 
	 */
	
	@RequestMapping(value="/ajaxlogin.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> ajaxLogin(HttpSession session, @RequestBody MYMemberDto dto){
		//@RequestBody얘가 jsp에서 제이슨 형태로 넘어오는걸 자바 형태로 바인딩 해준다 ,해당 세터에 넣어줌 
		//클라이언트 <->서버 데이터 넘어가는건 스트링 타입으로 넘어가는데 여기선 제이슨 타입으로 넘겨주고싶어서 
		//@RequestBody 는 contentType:"application/json" 얘(login.jsp에있음 ) 랑 같이쓴다 
		//멤버 id,pw의 세터가 dto에 있어야함 
		
			logger.info("[Controller] ajaxlogin.do");
		
			MYMemberDto res=biz.login(dto);
			boolean check=false;
			if(res!=null) {
				if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
					session.setAttribute("login", res);
					check=true;
				}
			}
			Map<String,Boolean> map =new HashMap<String,Boolean>();
			map.put("check", check);
		return map;
	}
	
	//회원가입 버튼 누르면 일로옴 
	@RequestMapping("/registform.do")
	public String insertform () {
		logger.info("[Controller] : registform.do");
		return "mymemberregist";
		
	}
	//회원가입 res 
	@RequestMapping( value = "/registres.do",method = RequestMethod.POST)
	public String insertres(MYMemberDto dto) {
		logger.info("[Controller] : registres.do");
		//int res=biz.insert(dto);
		//이제 암호화 하자 
		System.out.println("\n 암호화전 : "+dto.getMemberpw());
		//logger.info("\n 암호화전 : "+dto.getMemberpw());
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		System.out.println("\n 암호화후 : "+dto.getMemberpw());
		//logger.info("\n 암호화후 : "+dto.getMemberpw());
		if ( biz.insert(dto) >0 ) {
			return "redirect:loginform.do";
		}
		return "redirect:registform.do";	//실패시경로 
		
	}
}
