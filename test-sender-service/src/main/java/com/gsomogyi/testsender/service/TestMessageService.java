package com.gsomogyi.testsender.service;

import com.gsomogyi.testsender.dto.TestMessageDTO;
import com.gsomogyi.testsender.model.TestMessage;

public interface TestMessageService {

    Iterable<TestMessage> findAll();

    TestMessageDTO save(TestMessageDTO testMessage);

    void delete(TestMessage testMessage);
}