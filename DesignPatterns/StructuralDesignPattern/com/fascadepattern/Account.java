package com.fascadepattern;

public class Account {
    public boolean validate(int accNo,int pin) {
        return accNo >= 100_00 && accNo <= 99999 && pin == 1234; // just for simplicity
    }
}
