package com.jdh.practice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.jdh.practice.model.dao.test_b", sqlSessionFactoryRef = "BSqlSessionFactory")
public class BDataSourceConfig {

	private final String B_DATA_SOURCE = "BDataSource";

	// A database DataSource
	@Bean(B_DATA_SOURCE)
	@ConfigurationProperties(prefix = "spring.test-b.datasource.hikari")
	public DataSource BDataSource() {
		return DataSourceBuilder.create()
				.type(HikariDataSource.class)
				.build();
	}

	// SqlSessionTemplate 에서 사용할 SqlSession 을 생성하는 Factory
	@Bean
	public SqlSessionFactory BSqlSessionFactory(@Qualifier(B_DATA_SOURCE) DataSource dataSource) throws Exception {
		/*
		 * MyBatis 는 JdbcTemplate 대신 Connection 객체를 통한 질의를 위해서 SqlSession 을 사용한다.
		 * 내부적으로 SqlSessionTemplate 가 SqlSession 을 구현한다.
		 * Thread-Safe 하고 여러 개의 Mapper 에서 공유할 수 있다.
		 */
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);

		// MyBatis Mapper Source
		// MyBatis 의 SqlSession 에서 불러올 쿼리 정보
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/b/*Mapper.xml");
		bean.setMapperLocations(res);

		// MyBatis Config Setting
		// MyBatis 설정 파일
		Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
		bean.setConfigLocation(myBatisConfig);

		return bean.getObject();
	}

	// DataSource 에서 Transaction 관리를 위한 Manager 클래스 등록
	@Bean
	public DataSourceTransactionManager BTransactionManager(@Qualifier(B_DATA_SOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}