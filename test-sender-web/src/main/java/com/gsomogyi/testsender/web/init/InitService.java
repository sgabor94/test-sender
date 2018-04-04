package com.gsomogyi.testsender.web.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitService {

    private final TestData testData;

    @Autowired
    public InitService(TestData testData) {
        this.testData = testData;
    }

    @PostConstruct
    public void init() {
        testData.initTestData();
    }
}