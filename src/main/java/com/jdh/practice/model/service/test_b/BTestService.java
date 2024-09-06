package com.jdh.practice.model.service.test_b;

import com.jdh.practice.model.dao.test_b.BTestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BTestService {

	private final BTestMapper bTestMapper;

	public String getTest() throws Exception {
		return bTestMapper.selectTest();
	}
}
