package com.jdh.practice.model.dao.test_a;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ATestMapper {
	String selectTest() throws Exception;
}
