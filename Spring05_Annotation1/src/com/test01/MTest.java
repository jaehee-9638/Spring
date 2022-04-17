package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
		public static void main(String[] args) {
			
		
	ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
	
	//닉네임 클래스가 강사 리턴해서 마이닉네임에서 받아서 전체로 출력 
	MyNickNamePrn hello=factory.getBean("mynickname",MyNickNamePrn.class);
	
	System.out.println(hello);
		}
	
}
