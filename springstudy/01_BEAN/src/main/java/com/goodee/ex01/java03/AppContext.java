package com.goodee.ex01.java03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean(name="calc")	//<bean id="calc">
	public Calculator aaaz() {
		return new Calculator();
	}
	
	@Bean(name="gugudan")
	public Gugudan qwqwzz() {
		return new Gugudan(aaaz(), 3, 5);
	}
}
