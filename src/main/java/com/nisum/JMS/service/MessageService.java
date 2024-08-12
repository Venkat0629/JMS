package com.nisum.JMS.service;

import com.nisum.JMS.model.Email;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class MessageService {
    private JmsMessagingTemplate jmsMessagingTemplate;

    private final Email email = new Email(101, "Dear John Doe,\n\n" + "We are pleased to inform you that your application for the position of Software Engineer has been successful. " + "Congratulations!\n\n" + "Please find attached the offer letter with further details. We look forward to your acceptance and to welcoming you aboard.\n\n" + "Best regards,\n" + "The HR Team\n" + "Company XYZ", Arrays.asList("hr@companyxyz.com", "recruitment@companyxyz.com"), "Job Offer - Software Engineer", Arrays.asList("johndoe@example.com"));


    public Email sendMessage() {
        try {
            jmsMessagingTemplate.convertAndSend("Message Queue", email);
        } catch (MessagingException e) {
            throw new RuntimeException("Message is not published");
        }
        return email;
    }
}
