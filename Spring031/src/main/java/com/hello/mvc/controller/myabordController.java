package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.mvc.biz.MYBoardBiz;
import com.hello.mvc.dto.MYBoardDto;

@Controller
public class myabordController {
	
	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list",biz.selectList() );
		return "list";
	}
	@RequestMapping("/detail.do")
	public String selectOne(Model model,int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "detail";
	}
	@RequestMapping("/insertform.do")
	public String insertform() {
		return "insert";
	}
	@RequestMapping("/insertres.do")
	public String insertres(MYBoardDto dto){
		//여기서 값 받아서 확인해서 리턴 위치 정하는거임 
		//여기서 서버로 값 보내야한다고 이너마 
		int res =biz.insert(dto);
		
		if (res>0) {	//성공
			
			return "redirect:list.do";//이게 지금 컨트롤러로 가야함 
		}
		return "insert";
	}
	
	@RequestMapping("/updateform.do")
	public String updateform(Model model,int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "update";
	}
	@RequestMapping("updateres.do")
	public String updateres(MYBoardDto dto) {
		int res =0; 
		res=biz.update(dto);
		//System.out.println("컨트롤러에서 호출한 biz"+biz.update(dto));	//이거하면 두갰ㄱ 생기네 .... 
		if (res>0) {//성공하면 detail 로 
			return "redirect:detail.do?myno="+dto.getMyno();
		}
		return "redirect:updateform.do?myno="+dto.getMyno();	//실패하면 updateform 으로 
	}
	@RequestMapping("/deleteres.do")
	public String delete(int myno) {
		int res=0; 
		res=biz.delete(myno);
		if (res>0) {//성공 하면 리스트로 
			return "redirect:list.do";
		}
		return "redirect:detail.do&myno="+myno;	//실패 하면 다시 디테일 페이지로 
	}
}
