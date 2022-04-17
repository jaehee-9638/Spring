package com.test.mvc.common.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
	
	//컨트롤러보다 먼저 수행되는 메소드 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor1]:preHandle");
		
		
		//spring 3.2 이상부터는 servltet-context.xml에서 <exclude-mapping-path>를 사용하여 설정 가능 
		if(request.getRequestURI().contains("/memberLoginForm.do")) {
			return true;	//이거 false로하면 로그인 폼으로 안가짐;;;로그인 폼 으로 가면 로그인 페이지로 
		}
		if(request.getRequestURI().contains("/ajaxlogin.do")) {	//아작스 로그인 추가
			return true;	//컨트롤러에서 로그인 jsp값 확인한 애 
		}
		//트랜잭션 할때 추가한애 얘 추가하니까 인터셉터 안머금 
		if(request.getRequestURI().contains("/test.do")) {
			return true;
		}
		
		if (request.getRequestURI().contains("/boardList.do")) {
			return true;	//게시글 보는건 로그인 안해도된다. 
		}
		
		/*if (request.getRequestURI().contains("/memberLoginForm.do")||
			request.getRequestURI().contains("/ajaxlogin.do")||
			request.getRequestURI().contains("/test.do")||
			request.getRequestURI().contains("/boardList.do")) {
			
			return true;
		}*/
		
		
		if(request.getSession().getAttribute("login")!=null) {	
			
			return true;	//로그인 되어있는 상태 
		}
		if(request.getSession().getAttribute("login")==null) {
			//여기서 들어왔던 요청 저장해서 간다음에 포스트 핸들러에서 꺼내서 쓰는 식으로 해보깡 ?
			
			response.sendRedirect("memberLoginForm.do");
			return false;	//로그인 안되어있는 상태 
		}
		
		
		
		//true면 핸들러의 다음 체인 실행 ,false면 중단하고 남은 인터셉터와 컨트롤러 실행x
		
		return false;
		//false->true로
	}
	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		if(modelAndView !=null) {
		logger.info("[Interceptor2]:"+modelAndView.getViewName());
		}
	}
	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[Interceptor3]:afterCompletion");

	}

}
