package com.goodee.ex01.java02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.goodee.ex01.java01.SpringBeanConfig;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeanConfig.class);

		Student student = ctx.getBean("stu", Student.class);
		System.out.println("성적 : " + student.getScores().toString());
		System.out.println("수상내역 : " + student.getAwards().toString());
		System.out.println("정보 : " + student.getHome());
		
		ctx.close();
	}

}
