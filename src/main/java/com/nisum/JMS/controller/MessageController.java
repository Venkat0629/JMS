package com.nisum.JMS.controller;

import com.nisum.JMS.model.Email;
import com.nisum.JMS.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class MessageController {
    private MessageService messageService;

    @GetMapping
    public Email getMessage() {
        return messageService.sendMessage();
    }
}
