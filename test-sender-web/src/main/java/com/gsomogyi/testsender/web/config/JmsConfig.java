package com.gsomogyi.testsender.web.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

@Configuration
public class JmsConfig {

    private static final Logger logger = LoggerFactory.getLogger(JmsConfig.class);

    @Value("${message.broker.type}")
    private String messageBrokerType;

    @Bean
    public ConnectionFactory connectionFactory() throws JMSException {
        logger.info("Configure ActiveMQ ConnectionFactory...");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        connectionFactory.setTrustAllPackages(true);
        return connectionFactory;
    }
}
