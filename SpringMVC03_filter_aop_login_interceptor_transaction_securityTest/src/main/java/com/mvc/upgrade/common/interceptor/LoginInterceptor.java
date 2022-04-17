package com.mvc.upgrade.common.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor]:preHandle");
		
		//spring 3.2 이상부터는 servltet-context.xml에서 <exclude-mapping-path>를 사용하여 설정 가능 
		if(request.getRequestURI().contains("/loginform.do")||
			request.getRequestURI().contains("/ajaxlogin.do")||
			//request.getRequestURI().contains("/test.do")||	//얘넣어주면 트랜잭션 오류난ㄴ다 왜냐면 
			//이 경우에 계속 진행해야하는데 트랜젝션이 안맞아서 긍가... 쉬댕 왜그런지 이해불가
			request.getRequestURI().contains("/registform.do")||
			request.getRequestURI().contains("/registres.do")
				) {
			return true;	//요청 uri가 위에내용중하나면 진행 
		}
		if(request.getSession().getAttribute("login")!=null) {
			return true;	//로그인이 되어있으면 진행 
		}
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		
		
		
		return false;
		//false->true로
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println(modelAndView.getViewName());	//널포인트ㅇ읷ㅂ
		//logger.info("[Interceptorㅋㅋ]:"+modelAndView.getViewName());
		if(modelAndView !=null) {
		logger.info("[Interceptorㅋㅋ]:"+modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[Interceptor]:afterCompletion");

	}

}
