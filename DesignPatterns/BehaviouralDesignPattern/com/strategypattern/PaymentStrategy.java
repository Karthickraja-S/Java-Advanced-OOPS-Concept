package com.strategypattern;

public class PaymentStrategy {
    private final PaymentProcessor processor;

    public PaymentStrategy(PaymentProcessor processor) {
        this.processor = processor;
    }
    public void pay() {
        this.processor.pay();
    }
}
