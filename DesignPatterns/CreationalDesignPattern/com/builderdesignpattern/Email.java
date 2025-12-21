package com.builderdesignpattern;

import java.util.List;

public class Email {

    private String subject;
    private String from;
    private String to;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments;

//    public Email(String subject, String from, String to, String body, String cc, String bcc, List<String> attachments) {
//        this.subject = subject;
//        this.from = from;
//        this.to = to;
//        this.body = body;
//        this.cc = cc;
//        this.bcc = bcc;
//        this.attachments = attachments;
//    }

    public Email(EmailBuilder builder) {
        this.subject = builder.getSubject();
        this.from    = builder.getFrom();
        this.to      = builder.getTo();
        this.body    = builder.getBody();
        this.cc      = builder.getCC();
        this.bcc     = builder.getBcc();
        this.attachments = builder.getAttachments();
    }



}
