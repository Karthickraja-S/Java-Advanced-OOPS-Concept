package com.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    static void main() {
        System.out.println("Enter amount to withdraw : ( Must be multiples of 100, 500 , 1000 )");
        Scanner ip  = new Scanner(System.in);
        int amount = ip.nextInt();

        AbstractCashProcessor thousand = new ThousandCashProcessor();
        thousand
                .setNext(new FiveHundredCashProcessor())
                .setNext(new HundredCashProcessor()); // we can include 200 processor if needed and remove 500 processor easily

        Map<Integer,Integer> amountMap = new HashMap<>();
        thousand.processAmount(amountMap , amount);

        System.out.println(amountMap);
    }
}
