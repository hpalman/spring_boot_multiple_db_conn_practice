package com.jdh.practice.model.dao.test_b;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BTestMapper {
	String selectTest() throws Exception;
}