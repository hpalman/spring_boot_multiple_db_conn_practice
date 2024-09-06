package com.jdh.practice.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdh.practice.model.service.test_b.BTestService;

@RestController
public class BController {

	private final BTestService bTestService;
    public BController(BTestService bTestService) {
        this.bTestService = bTestService;
    }

	@GetMapping("/hellob")
    public String sayHello() throws Exception {
		String ret = bTestService.getTest();

        return "helloa! Hello, Spring Boot! [" + ret + "]";
    }
}
