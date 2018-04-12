package com.gsomogyi.testsender.service;

import com.gsomogyi.testsender.dto.TestMessageDTO;
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
    public TestMessageDTO save(TestMessageDTO testMessage) {
        logger.info("TestMessage saved with id: {}", testMessage);
        TestMessage saved = testMessageRepository.save(new TestMessage(testMessage.getContent(), testMessage.getSource(), testMessage.getSendDate()));
        return new TestMessageDTO(saved.getContent(), saved.getSource(), saved.getSendDate());
    }

    @Override
    public void delete(TestMessage testMessage) {
        logger.info("TestMessage deleted with id: {}", testMessage);
        testMessageRepository.delete(testMessage);
    }
}
