package com.gsomogyi.testsender.web.controller;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.service.TestMessageCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class TestMessageController {

    private final TestMessageCRUDService testMessageCRUDService;

    @Autowired
    public TestMessageController(TestMessageCRUDService testMessageCRUDService) {
        this.testMessageCRUDService = testMessageCRUDService;
    }

    @CrossOrigin
    @GetMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<TestMessage>> getTestMessages() {
        Iterable<TestMessage> allTestMessage = testMessageCRUDService.findAll();
        return ResponseEntity.ok(allTestMessage);
    }
}
