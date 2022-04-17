package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.MyOrderBiz;

import com.mvc.upgrade.model.dto.MyOrderDto;


@Controller
public class MyOrderController {

	@Autowired
	private MyOrderBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model ) {
		model.addAttribute("list",biz.myOrderSelectList());
		//Model addAttribute(String name, Object value) : value객체를
		//name이름으로 추가한다. 뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용한다. 
		
		return "myorderlist";
	}
	@RequestMapping("/writeform.do")
	public String insertForm() {
		return"myorderinsert";
	}
	@RequestMapping(value="/writeres.do",method=RequestMethod.POST)
	public String insertRes(MyOrderDto dto) {
		
		if(biz.myOrderInsert(dto)>0) {
			return "redirect:list.do";
		}
		
		return "redirect:writeform.do";
	}
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int orderSeq) {
		
		model.addAttribute("dto",biz.myOrderSelectOne(orderSeq));
		
		return "myorderdetail";
	}
	@RequestMapping("/delete.do")
	public String delete(int orderSeq) {
		
		if(biz.myOrderDelete(orderSeq)>0) {
			return"redirect:list.do";
			//redirect는 페이지를 넘겨줄때 사용한다. 
			//list.do위치에 넘겨줄 context경로를 입력하면된다. 
		}
		
		return"redirect:detail.do?orderSeq="+orderSeq;
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model,int orderSeq) {
		model.addAttribute("dto",biz.myOrderSelectOne(orderSeq));
		
		return "myorderupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes (MyOrderDto dto) {
		if(biz.myOrderUpdate(dto)>0) {
			return "redirect:detail.do?orderSeq="+dto.getOrderSeq();
		}
		return "redirect:updateform.do?orderSeq="+dto.getOrderSeq();
		
		
	}
	
}
