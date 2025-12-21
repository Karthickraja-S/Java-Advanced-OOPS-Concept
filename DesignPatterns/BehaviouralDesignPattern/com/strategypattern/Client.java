package com.strategypattern;

import java.util.Scanner;

public class Client {
    static void main() {
        System.out.println("Enter the payment mode : 1-Gpay, 2-Card");
        Scanner ip = new Scanner(System.in);
        int choice = ip.nextInt();

        PaymentStrategy strategy = null;
        // use a factory pattern to create object and return.
        if(choice == 1) {
            strategy = new PaymentStrategy(new GpayPayment(1234));
        } else if(choice == 2) {
            strategy = new PaymentStrategy(new CardPayment(666666,1234,876));
        } else {
            System.out.println("Cash on delivery chosen by default.");
        }
        if(strategy!= null) strategy.pay();
    }
}
