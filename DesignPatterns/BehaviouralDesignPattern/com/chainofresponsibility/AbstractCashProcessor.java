package com.chainofresponsibility;


import java.util.Map;

public abstract class AbstractCashProcessor {
    private AbstractCashProcessor next;

    public AbstractCashProcessor setNext(AbstractCashProcessor cashProcessor) {
        this.next = cashProcessor;
        return cashProcessor;
    }

    protected void callNext(Map<Integer,Integer> mp , int amount) {
       if(next != null) next.processAmount(mp , amount);
    }

    public abstract void processAmount(Map<Integer,Integer> hm , int amount);
}
