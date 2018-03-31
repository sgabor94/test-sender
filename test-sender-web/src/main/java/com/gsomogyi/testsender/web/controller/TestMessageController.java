package com.gsomogyi.testsender.web.controller;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageCRUDService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class TestMessageController {


    private final TestMessageCRUDService testMessageCRUDService;

    public TestMessageController(TestMessageCRUDService testMessageCRUDService) {
        this.testMessageCRUDService = testMessageCRUDService;
    }

    @GetMapping(value = {"", "/"})
    public Iterable<TestMessage> getTestMessages() {
        return testMessageCRUDService.findAll();
    }

    @PostMapping(value = "/save")
    public TestMessage saveTestMessage(@RequestBody TestMessage testMessage) {
        return testMessageCRUDService.save(testMessage);
    }
}
