package com.internal.paymentprocessor;

public class UPIPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(int amount) {
        System.out.println("Processing payment of amount : "+amount);
        return true;
    }
}
