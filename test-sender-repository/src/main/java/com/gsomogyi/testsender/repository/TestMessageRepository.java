package com.gsomogyi.testsender.repository;

import com.gsomogyi.testsender.model.TestMessage;
import org.springframework.data.repository.CrudRepository;

public interface TestMessageRepository extends CrudRepository<TestMessage, Long> {
}
