package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
	//slf4j :로그찍기위한 인터페이스 ,얘를 실제 구현하는애가 log4j임 
	public void before(JoinPoint join) {
		Logger logger=LoggerFactory.getLogger(join.getTarget()+"");	//대상객체
		//dao의 앞뒤로 놓을거임 비포는 다오 앞 애프터는 다오뒤에 나오게 설정 할거임 
		logger.info("-------------AOP Start--------");
		
		Object[]args=join.getArgs();		//대상 파라미터 
		if (args != null) {
			logger.info("method:" +join.getSignature().getName());	//대상 메서드 정보 
			for (int i=0; i<args.length; i++) {
				logger.info(i+"번째 :"+args[i]);
			}
			
		}
	}
	
	public void after(JoinPoint join) {
		Logger logger=LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("---------AOP End------");
	}
	
	public void afterThrowing(JoinPoint join) {
		Logger logger=LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("-----------AOP Error Log--------------");
		logger.info("ERROR:"+join.getArgs());
		logger.info("ERROR:"+join.toString());
	}

}
