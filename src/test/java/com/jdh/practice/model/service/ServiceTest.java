package com.jdh.practice.model.service;

import com.jdh.practice.model.service.test_a.ATestService;
import com.jdh.practice.model.service.test_b.BTestService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    Logger log = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    ATestService aTestService;

    @Autowired
    BTestService bTestService;


    @Test
    public void test() throws Exception {
        log.info("mapper a :: " + aTestService.getTest());
        log.info("mapper b :: " + bTestService.getTest());
    }
}