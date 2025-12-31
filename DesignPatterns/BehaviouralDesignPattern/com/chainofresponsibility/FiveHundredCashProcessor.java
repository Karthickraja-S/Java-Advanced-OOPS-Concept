package com.chainofresponsibility;

import java.util.Map;

public class FiveHundredCashProcessor extends AbstractCashProcessor{
    @Override
    public void processAmount(Map<Integer, Integer> hm, int amount) {
        if(amount >= 500) {
            int fiveHundredCash = amount / 500;
            hm.put(500 , fiveHundredCash);
            amount = amount - (fiveHundredCash * 500);
        }
        callNext(hm , amount);
    }
}
