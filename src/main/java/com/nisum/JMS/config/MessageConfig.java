package com.nisum.JMS.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessageConfig {
    @Value("${activemq.url}")
    private String activemqUrl;

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
        return new JmsMessagingTemplate(jmsTemplate);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(activemqUrl);
    }
}
