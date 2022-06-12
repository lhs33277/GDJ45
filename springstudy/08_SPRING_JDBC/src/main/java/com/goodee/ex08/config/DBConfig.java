package com.goodee.ex08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement  // 트랜잭션 동작(TransactionManager)을 허용합니다.

@Configuration
public class DBConfig {

	// Spring JDBC
	// 1. DataSorce를 bean으로 등록한다.
	// 2. JdbcTemplate을 bean으로 등록한다.
	//    이 때, DataSorce bean이 JdbcTemplate bean의 field로 사용된다. (재료로 사용된다.)
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("1111");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());	// 위에건 재료용, 이걸 가져다 씀. jdbc라고 써있지만 내부동작은 dbcp
		return jdbcTemplate;
	}
	
	// Spring JDBC의 Transaction 처리
	// TransactionManager를 bean으로 등록한다.
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
