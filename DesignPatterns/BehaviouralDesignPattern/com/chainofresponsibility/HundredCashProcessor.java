package com.chainofresponsibility;

import java.util.Map;

public class HundredCashProcessor extends AbstractCashProcessor {
    @Override
    public void processAmount(Map<Integer, Integer> hm, int amount) {
        if(amount >= 100) {
            int hundredCurrency = amount / 100;
            hm.put(100 , hundredCurrency);
            amount = amount - (hundredCurrency * 100);
        }
        callNext(hm , amount);
    }
}
