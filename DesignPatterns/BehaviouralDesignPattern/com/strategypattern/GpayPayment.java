package com.strategypattern;

public class GpayPayment implements PaymentProcessor{
    private int pin;
    public GpayPayment(int pin) {
        this.pin = pin;
    }
    public void pay() {
        System.out.println("Processing payment with Gpay Accounts...");
    }
}
