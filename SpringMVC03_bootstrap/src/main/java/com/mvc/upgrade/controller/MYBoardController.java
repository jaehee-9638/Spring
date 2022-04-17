package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {
	//웹 요청과 응답을 처리함 , 웹 어플리케이션에서 컨트롤러 역활을 하는 클래스에 
	
	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model ) {
		model.addAttribute("list",biz.selectList());
		//Model addAttribute(String name, Object value) : value객체를
		//name이름으로 추가한다. 뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용한다. 
		
		return "myboardlist";
	}
	@RequestMapping("/writeform.do")
	public String insertForm() {
		return"myboardinsert";
	}
	@RequestMapping(value="/writeres.do",method=RequestMethod.POST)
	public String insertRes(MYBoardDto dto) {
		
		if(biz.insert(dto)>0) {
			return "redirect:list.do";
		}
		
		return "redirect:writeform.do";
	}
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto",biz.selectOne(myno));
		
		return "myboarddetail";
	}
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		
		if(biz.delete(myno)>0) {
			return"redirect:list.do";
			//redirect는 페이지를 넘겨줄때 사용한다. 
			//list.do위치에 넘겨줄 context경로를 입력하면된다. 
		}
		
		return"redirect:detail.do?myno="+myno;
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model,int myno) {
		model.addAttribute("dto",biz.selectOne(myno));
		
		return "myboardupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes (MYBoardDto dto) {
		if(biz.update(dto)>0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}
		return "redirect:updateform.do?myno="+dto.getMyno();
		
		
	}
	
}
