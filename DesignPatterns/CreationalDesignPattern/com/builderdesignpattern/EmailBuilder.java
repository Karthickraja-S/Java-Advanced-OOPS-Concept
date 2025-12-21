package com.builderdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class EmailBuilder {
    private String subject;
    private String from;
    private String to;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments = new ArrayList<>();


    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    public EmailBuilder setFrom(String from) {
        this.from = from;
        return this;
    }
    public EmailBuilder setTo(String to){
        this.to = to;
        return this;
    }
    public EmailBuilder setBody(String body){
        this.body = body;
        return this;
    }
    public EmailBuilder setCC(String cc){
        this.cc = cc;
        return this;
    }
    public EmailBuilder setBcc(String bcc) {
        this.bcc = bcc;
        return this;
    }
    public EmailBuilder addAttachments(String attachments){
        this.attachments.add(attachments);
        return this;
    }

    public Email build() {
        // Here we can even validate from != null , to != null , body != null , Subject != null
        return new Email(this);
    }

    public String getSubject() {return subject;}
    public String getFrom() {return from;}
    public String getTo() {return to;}
    public String getBody() {return body;}
    public String getCC() {return cc;}
    public String getBcc() {return bcc;}
    public List<String> getAttachments() {return attachments;}
}
