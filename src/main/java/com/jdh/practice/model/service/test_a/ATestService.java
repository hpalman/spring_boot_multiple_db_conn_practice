package com.jdh.practice.model.service.test_a;

import com.jdh.practice.model.dao.test_a.ATestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ATestService {

	private final ATestMapper aTestMapper;

	public String getTest() throws Exception {
		return aTestMapper.selectTest();
	}
}