package com.fascadepattern;

public class Client {
    static void main() {
        BankFascade fascade = new BankFascade();
        fascade.withdraw(12345,1234,5000);

        // if there is no fascade, then for withdraw each client need to duplicate the if check code
        // fascade is nothing just a method which wraps multiple operations that can be used by client
        // instead of writing their logic.
    }
}
