package com.hello.mvc.interception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercept implements HandlerInterceptor{
	
	private Logger logger=LoggerFactory.getLogger(LoginIntercept.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getRequestURI().contains("/login.do")) {
			return true;
		}
		if(request.getRequestURI().contains("/logincontrol.do")) {
			return true;
		}
		if(request.getSession().getAttribute("login")!=null) {
			return true;
		}
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("login.do");
			return false;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null) {
			logger.info("[interceptor2] : "+modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
			logger.info("[interceptor3] : afterCompletion");
	}

}
