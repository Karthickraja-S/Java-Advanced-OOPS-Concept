package com.internal.paymentprocessor;

public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(int amount) {
        System.out.println("Processing payment by Card : "+amount);
        return true;
    }
}
