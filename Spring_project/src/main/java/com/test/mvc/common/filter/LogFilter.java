package com.test.mvc.common.filter;

import java.io.IOException;




import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
	private Logger logger=LoggerFactory.getLogger(LogFilter.class);
	//org.slf4j 임포트

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터만들어질때 실행되는 메소드 

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//HttpServletRequest객체는 jsp/servlet요청 정보를 제공하기 위한 ServletRequest인터페이스를 상속한 객체임 
		//서블릿 컨테이너는 HttpServletRequest객체를 생성하여 doGet(),doPost()등을 서블릿 서비스 인자로 전달함 
		HttpServletRequest req= (HttpServletRequest) request;
		//remoteAddr,uri,url,queryString,referer,agent
		String remoteAddr = req.getRemoteAddr();
		String uri=req.getRequestURI();
		String url=req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer=req.getHeader("referer");
		String agent=req.getHeader("User-Agent");
		
		StringBuffer sb= new StringBuffer();
		sb.append("\n* remoteAddr : "+ remoteAddr)  // ip주소를 얻는다
			//ipv4로 뜨게 하려면 127.0.0.1로 요청 해보자 ->127.0.0.1:8787/upgrade/list.do 이런식으로 고쳐서 해보면 콘솔에 잘 나옴 
			.append("\n* uri: "+uri)  //컨텍스트 패스   Http요청 URL 중 포트번호와 쿼리 사이의 부분, 즉 컨텍스트 경로+서블릿 경로
			.append("\n* url: "+url) //전체주소   쿼리를 제외한 프로토콜+도메인+포트번호+컨텍스트 경로+서블릿 경로
			.append("\n* queryString: "+queryString) //key=value 형태로 테이터 전달       쿼리(query)를 얻어옵니다., 경로 뒤에있는 요청 쿼리 문자열 
			.append("\n* referer: "+referer)  // 이전 페이지(보내는 페이지) url (getHeader: 지정한 요청 헤더값을 문자열로 반환)
			.append("\n* agent: "+agent)  // 사용자 정보(browser, os등 ...)
			.append("\n");
		
		logger.info("\nLOG Filter" +sb); // filter가 실행
		
		chain.doFilter(req, response);
		 // 다음에 존재하는 필터가 있으면, 그 필터가 실행될 수 있도록 chaining!
        // request에 들어있는 정보를 읽어서 sb에 저장 한 것!

	}

	@Override
	public void destroy() {
		//필터종료될때 실행되는 메소드 

	}

}
