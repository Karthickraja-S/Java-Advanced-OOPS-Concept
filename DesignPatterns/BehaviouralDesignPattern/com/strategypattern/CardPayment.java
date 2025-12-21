package com.strategypattern;

public class CardPayment implements PaymentProcessor{
    private int accNo;
    private int pin;
    private int cvv;
    public CardPayment(int accNo ,int pin , int cvv) {
        this.accNo = accNo;
        this.pin = pin;
        this.cvv = cvv;
    }
    @Override
    public void pay(){
        System.out.println("Processing payment with card payment with accNo : "+accNo);
    }

}
