package com.builderdesignpattern;

public class Client {
    static void main() {
        // If the user needs to attach cc, bcc , attachments he can do without constructor.
        // Also this provides immutable object

        EmailBuilder builder = new EmailBuilder();
        Email email = builder
                .setSubject("Regarding leave letter")
                .setFrom("myemail@gmail.com")
                .setTo("manager@company.com")
                .setBody("I need leave today")
                .build();
    }
}
