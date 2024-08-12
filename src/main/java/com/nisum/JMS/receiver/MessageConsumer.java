package com.nisum.JMS.receiver;

import com.nisum.JMS.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MessageConsumer {

    @JmsListener(destination = "Message Queue")
    public void receiveMessage(Email email) {
        System.out.printf("Message Received :%s\n", email);
    }
}
