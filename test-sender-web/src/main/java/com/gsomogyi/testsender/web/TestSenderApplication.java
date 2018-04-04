package com.gsomogyi.testsender.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gsomogyi.testsender")
@SpringBootApplication
public class TestSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSenderApplication.class, args);
    }
}
