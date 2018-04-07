package com.gsomogyi.testsender.service;

import com.gsomogyi.testsender.model.TestMessage;

public interface TestMessageService {

    Iterable<TestMessage> findAll();

    TestMessage save(TestMessage testMessage);

    void delete(TestMessage testMessage);
}