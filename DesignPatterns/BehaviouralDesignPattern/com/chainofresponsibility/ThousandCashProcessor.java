package com.chainofresponsibility;

import java.util.Map;

public class ThousandCashProcessor extends AbstractCashProcessor{
    @Override
    public void processAmount(Map<Integer, Integer> hm, int amount) {
        if(amount >= 1000) {
            int thousandCurrency = amount / 1000;
            hm.put(1000 , thousandCurrency);
            amount = amount - (thousandCurrency*1000);
        }
    //    System.out.println("In 1000CashProcessor amount : "+amount);
        callNext(hm , amount);
    }
}
