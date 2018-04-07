package com.gsomogyi.testsender.service;

import com.gsomogyi.testsender.model.TestMessage;
import com.gsomogyi.testsender.repository.TestMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMessageServiceImpl implements TestMessageService {

    private static final Logger logger = LoggerFactory.getLogger(TestMessageServiceImpl.class);

    private final TestMessageRepository testMessageRepository;

    @Autowired
    public TestMessageServiceImpl(TestMessageRepository testMessageRepository) {
        this.testMessageRepository = testMessageRepository;
    }

    @Override
    public Iterable<TestMessage> findAll() {
        return testMessageRepository.findAll();
    }


    @Override
    public TestMessage save(TestMessage testMessage) {
        logger.info("TestMessage saved with id: {}", testMessage);
        return testMessageRepository.save(testMessage);
    }

    @Override
    public void delete(TestMessage testMessage) {
        logger.info("TestMessage deleted with id: {}", testMessage);
        testMessageRepository.delete(testMessage);
    }
}
