package com.nisum.JMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    private Integer id;
    private String body;
    private List<String> ccList;
    private String subject;
    private List<String> toList;
}
