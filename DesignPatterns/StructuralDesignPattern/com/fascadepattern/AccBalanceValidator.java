package com.fascadepattern;

public class AccBalanceValidator {
    public boolean checkBalance(int accNo , int requested) {
        return requested >= 0 && requested <= 10_000;
    }
}
