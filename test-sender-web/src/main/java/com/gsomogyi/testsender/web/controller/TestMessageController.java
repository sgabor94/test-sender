package com.gsomogyi.testsender.web.controller;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class TestMessageController {

    private final TestMessageService testMessageService;

    @Autowired
    public TestMessageController(TestMessageService testMessageService) {
        this.testMessageService = testMessageService;
    }

    @CrossOrigin
    @GetMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<TestMessage>> getTestMessages() {
        Iterable<TestMessage> allTestMessage = testMessageService.findAll();
        return ResponseEntity.ok(allTestMessage);
    }
}
