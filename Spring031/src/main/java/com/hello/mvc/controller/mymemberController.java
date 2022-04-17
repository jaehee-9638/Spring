package com.hello.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.mvc.biz.MYMemberBiz;
import com.hello.mvc.dto.MYMemberDto;

@Controller
public class mymemberController {
	
	private Logger logger=LoggerFactory.getLogger(mymemberController.class);
	
	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping(value="/login.do")
	public String login() {
		logger.info("[Controller] : login.do");
		return "login";
	}
	
	@RequestMapping(value = "/logincontrol.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean>  logincheck(HttpSession session,@RequestBody MYMemberDto dto){
		MYMemberDto res =biz.login(dto);
		Map<String,Boolean> map =new HashMap<String, Boolean>();
		boolean check =false;
		
		if (res != null) {
			session.setAttribute("login", res);
			check=true;
		}
		
		map.put("check", check);
		
		return map;
		
	}
}
