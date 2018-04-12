package com.gsomogyi.testsender.service.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import javax.jms.BytesMessage;
import java.io.Serializable;

@Service
public class MessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private JmsTemplate jmsTemplate;

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final Serializable testMessage, final String destinationName) {
        logger.info("MessageSender sending testMessage: {}", testMessage);
        if (destinationName != null) {
            logger.info("Sending to: {}", destinationName);
            jmsTemplate.send(destinationName, session -> {
                BytesMessage bytesMessage = session.createBytesMessage();
                bytesMessage.writeBytes(SerializationUtils.serialize(testMessage));
                return bytesMessage;
            });
        } else {
            logger.info("Sending to default: {}", jmsTemplate.getDefaultDestinationName());
            jmsTemplate.send(session -> session.createObjectMessage(testMessage));
        }
    }

}