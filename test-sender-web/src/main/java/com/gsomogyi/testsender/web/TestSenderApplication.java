package com.gsomogyi.testsender.web;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageCRUDService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@ComponentScan(basePackages = "com.gsomogyi.testsender")
@EnableJpaRepositories("com.gsomogyi.testsender.repository")
@EntityScan("com.gsomogyi.testsender.model")
@SpringBootApplication
public class TestSenderApplication {

    @Bean
    CommandLineRunner clr(TestMessageCRUDService testMessageCRUDService) {
        return args -> {
            testMessageCRUDService.save(new TestMessage(1L,"content1", "source1", new Date()));
            testMessageCRUDService.save(new TestMessage(2L,"content2", "source2", new Date()));
            testMessageCRUDService.save(new TestMessage(3L,"content3", "source3", new Date()));
            testMessageCRUDService.save(new TestMessage(4L,"content4", "source4", new Date()));
            testMessageCRUDService.save(new TestMessage(5L,"content5", "source5", new Date()));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TestSenderApplication.class, args);
    }
}
