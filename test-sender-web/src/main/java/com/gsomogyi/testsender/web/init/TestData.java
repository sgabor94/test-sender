package com.gsomogyi.testsender.web.init;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestData {

    private final TestMessageCRUDService testMessageCRUDService;

    @Autowired
    public TestData(TestMessageCRUDService testMessageCRUDService) {
        this.testMessageCRUDService = testMessageCRUDService;
    }

    void initTestData() {
        TestMessage testMessage = new TestMessage();
        testMessage.setContent("Test Message 1");
        testMessage.setSendDate(new Date());
        testMessage.setSource("Source1");
        testMessageCRUDService.save(testMessage);
    }
}
