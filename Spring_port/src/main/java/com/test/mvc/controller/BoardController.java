package com.test.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController  {
	
	//컨트롤러는 값 받고 처리하는곳이자너 ...그럼 메소드 일단 만들어 
	@RequestMapping(value = "/selectList.do")
	public String selectList() {
		
		return "boardSelectList";
	}
	
}
