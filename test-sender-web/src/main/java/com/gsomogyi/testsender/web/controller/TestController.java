package com.gsomogyi.testsender.web.controller;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageService;
import com.gsomogyi.testsender.service.jms.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final MessageSender messageSender;

    private final TestMessageService testMessageService;

    @Autowired
    public TestController(MessageSender messageSender, TestMessageService testMessageService) {
        this.messageSender = messageSender;
        this.testMessageService = testMessageService;
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public String postMessage(@RequestBody TestMessage testMessage) {
        logger.info("postMessage called, testMessage: {}", testMessage);
        messageSender.sendMessage(testMessage, "INBOX");
        testMessageService.save(testMessage);
        return "Message posted";
    }
}
