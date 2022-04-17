package com.test.mvc.controller;




import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.mvc.member.biz.MyMemberBiz;
import com.test.mvc.member.dto.MyMemberDto;

@Controller
public class MyMemberController {

	private Logger logger=LoggerFactory.getLogger(MyMemberController.class);
	
	//암호화 하는 ㄱ객체
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MyMemberBiz biz;
	
	
	@RequestMapping("/memberLoginForm.do")
	public String loginForm(HttpServletRequest request) {
		
		//지금 이전 요청 찾는거까진 했는데 이걸 인터셉터 적용되도록 하는걸 못하게씀 ....
		String referer = request.getHeader("referer");
		System.out.println("이전요청: "+referer);
		
		
		return "memberLogin";	//로긴 페이지로 같이 가고 로긴 페이지에서 
		
	}
	
	
	//아작스 로그인 
		@RequestMapping(value="/ajaxlogin.do",method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Boolean> ajaxLogin(HttpSession session, @RequestBody MyMemberDto dto){
			//@RequestBody얘가 jsp에서 제이슨 형태로 넘어오는걸 자바 형태로 바인딩 해준다 ,해당 세터에 넣어줌 
			//클라이언트 <->서버 데이터 넘어가는건 스트링 타입으로 넘어가는데 여기선 제이슨 타입으로 넘겨주고싶어서 
			//@RequestBody 는 contentType:"application/json" 얘(login.jsp에있음 ) 랑 같이쓴다 
			//멤버 id,pw의 세터가 dto에 있어야함 
				MyMemberDto res=biz.login(dto);
				boolean check=false;
				if(res != null) {	//로그인 성공
					session.setAttribute("login", res);
					check=true;
					
					
				}
				Map<String,Boolean> map =new HashMap<String,Boolean>();
				map.put("check", check);
				
			return map;
		}
		
	//로그인정보 꺼내서 유저인지 관리자인지 조회한다음 usermain이나 adminmain으로 가자 	
	@RequestMapping("/loginRes.do")
	public String loginRes(HttpSession session,HttpServletRequest request) {
		MyMemberDto dto =(MyMemberDto) session.getAttribute("login");
		
		System.out.println("접속시도한 회원의 회원 번호: "+dto.getMember_no());
		//가입여부 
		session.setAttribute("login",dto);
		session.setMaxInactiveInterval(60*60);
		
		
		if (dto.getMember_enabled().equals("Y")) {
			
			if(dto.getMember_role().equals("ADMIN")) {
				return "memberAdminMain";
			}else if(dto.getMember_role().equals("USER")) {
				return "memberUserMain";
			}
		}else if (dto.getMember_enabled().equals("N")) {
			System.out.println("탈퇴한 회원임"); 
			return "redirect:memberLoginForm.do";
		}
			//유저 어드민 
		return "";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		logger.info("[Controller]:logout.do");
		session.invalidate();
		return "redirect:memberLoginForm.do";
	}
	
		
	@RequestMapping(value = "/registForm.do")
	public String registForm() {
		logger.info("[Controller]:reqistform.do");
		return "memberRegist";
	}
	
	@RequestMapping(value = "/registres.do",method =RequestMethod.POST )
	public String registRes(MyMemberDto dto) {
		logger.info("[Controller]:reqistres.do");
		System.out.println("암호화 전:"+dto.getMember_pw());	//내가 입력한 문자
		dto.setMember_pw(passwordEncoder.encode(dto.getMember_pw()));
		System.out.println("암호화 후:"+dto.getMember_pw());	//암호화후 주소값처럼 생긴거 나옴 
		
		
		if (biz.regist(dto)>0) {
			return "redirect:memberLoginForm.do";
		}else {
			return "redirect:registFrom.do";
		}
	}
	
	@RequestMapping(value = "/myInfo.do")
	public String myInfo(Model model,int member_no) {
		//여기는 이제 누르면 셀렉트 원 보여주면 되는거임 
		
		MyMemberDto dto = biz.myInfo(member_no);
		model.addAttribute("dto", dto);
		return "memberMyInfo";
	}
	
	@RequestMapping("/myInfoUpdate.do")
	public String myInfoUpdateForm(Model model,int member_no) {
		model.addAttribute("dto",biz.myInfo(member_no));
		return "memberMyInfoUpdate";
	}
	
	@RequestMapping(value = "/myInfoUpdateRes.do",method = RequestMethod.POST)
	public String myInfoUpdateRes(@RequestParam Map<String,Object> param) {
		int res=0;		
		res=biz.myInfoUpdate(param);
	
		if (res>0) {//성공시 myinfo로
			return "redirect:myInfo.do?member_no="+param.get("member_no");
		}else {//실패시 다시 업데이트 from 으로 
			return "redirect:myInfoUpdate.do?member_no="+param.get("member_no");
		}
	}
	
	@RequestMapping(value = "/dropId.do" ,method = RequestMethod.GET)
	public String deleteRes(MyMemberDto dto) {
		//딜리트는 업데이트 하는거니까 개인정보 페이지에서 글번호 받아서 
		System.out.println("여기까지오나" +dto.getMember_no()+dto.getMember_role());	
		//오긴함 
		int res = biz.dropId(dto);
		
		if (res>0){
			System.out.println("res:"+res+":성공");
			return "redirect:memberLogin.do";
			
		}
		System.out.println("res:"+res+":실패");
		return "redirect:memberLogin.do";
	}
	//그냥 테스트
	@RequestMapping(value = "/testtest.do")
	public String testg() {
		return "test";
	}
	
	
	
	

}
