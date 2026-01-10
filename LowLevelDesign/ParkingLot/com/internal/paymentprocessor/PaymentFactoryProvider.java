package com.internal.paymentprocessor;

import com.enums.PaymentMode;

public class PaymentFactoryProvider {
    public PaymentProcessor getPaymentProcessor(PaymentMode mode) {
        switch (mode) {
            case UPI -> {
                return new UPIPaymentProcessor();
            }
            case CARD ->{
                return new CardPaymentProcessor();
            }
            default ->{
                return new CashPaymentProcessor();
            }
        }
    }

    static void main() {
        new PaymentFactoryProvider().getPaymentProcessor(PaymentMode.CARD).processPayment(12);
    }
}
