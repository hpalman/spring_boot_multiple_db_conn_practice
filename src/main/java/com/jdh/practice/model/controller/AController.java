package com.jdh.practice.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdh.practice.model.service.test_a.ATestService;

@RestController
public class AController {

	private final ATestService aTestService;
    public AController(ATestService aTestService) {
        this.aTestService = aTestService;
    }

	@GetMapping("/helloa")
    public String sayHello() throws Exception {
		String ret = aTestService.getTest();
        return "helloa! Hello, Spring Boot! [" + ret + "]";
    }

}
