package com.test.mv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mv.biz.MyMemberBiz;

@Controller
public class memberController {
	
	@Autowired(required = true)
	private MyMemberBiz biz;
	
	@RequestMapping(value="/memberList.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "memberList";
	}
	
	
}
