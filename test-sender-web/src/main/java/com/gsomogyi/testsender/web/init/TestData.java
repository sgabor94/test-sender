package com.gsomogyi.testsender.web.init;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestData {

    private final TestMessageService testMessageService;

    @Autowired
    public TestData(TestMessageService testMessageService) {
        this.testMessageService = testMessageService;
    }

    void initTestData() {
        TestMessage testMessage = new TestMessage();
        testMessage.setContent("Test Message 1");
        testMessage.setSendDate(new Date());
        testMessage.setSource("Source1");
        testMessageService.save(testMessage);
    }
}
