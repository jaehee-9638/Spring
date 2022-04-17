package com.hello.mvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.mvc2.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/command.do",method=RequestMethod.GET)
	public String getCommand(Model model, @RequestParam("name") String name,String addr,String phone) {
		
		model.addAttribute("dto",new AddressDto(name,addr,phone));
		
		return"get";
	}
	@RequestMapping(value="/command.do",method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		model.addAttribute("dto",dto);
		
		return "post";
	}
	
	@RequestMapping("/void.do")
	//리턴스트링없으면 void.do 로 찾음 
	public void voidPage(Model model) {
		model.addAttribute("message","viewname 안써도 넘어가집니다");
	}
	@RequestMapping("/product.do")
	
	public void productPage(Model model) {
		model.addAttribute("상품페이지");
	}
@RequestMapping("/pay.do")
	
	public void payPage(Model model) {
		model.addAttribute("결제 페이지");
	}

@RequestMapping("/mypage.do")

public void myPage(Model model) {
	model.addAttribute("결제 페이지");
}



}
