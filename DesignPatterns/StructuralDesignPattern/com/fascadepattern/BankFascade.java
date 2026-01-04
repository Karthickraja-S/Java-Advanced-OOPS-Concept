package com.fascadepattern;

public class BankFascade {
    Account account;
    AccBalanceValidator accBalanceValidator;
    public BankFascade() {
        account = new Account();
        accBalanceValidator = new AccBalanceValidator();
    }
    public void withdraw(int accNo , int pin,int requested) {
        if(account.validate(accNo,pin) && accBalanceValidator.checkBalance(accNo,requested)) {
            System.out.println("Validated. going to withdraw amount");
            // withdraw logic , and notification sending logic
        } else {
            System.out.println("Not validated!");
        }
    }
}
