package com.factorydesignpattern;

import java.util.Scanner;

public class ClientMain {
    static void main() {
        System.out.println("Enter which database you are using (mssql/pgsql) : ");
        Scanner ip = new Scanner(System.in);
        DatabaseHandler handler;

        // HERE WE ARE WRITING THIS BELOW LOGIC WHICH NEEDS TO BE WRITTEN BY MANY CLIENTS
        // WITH HELP OF FACTORY PATTERN WE CAN GET THOSE OBJECT AND HANDLED INTERNALLY
        String sql = ip.nextLine();
        if(sql.equalsIgnoreCase("pgsql")) {
            handler = new PGSQLDatabaseHandler("localhost:2000","admin","admin");
        } else if(sql.equalsIgnoreCase("mssql")) {
            handler = new MSSQLDatabaseHandler("localhost:3000","admin","admin");
        } else {
            throw new IllegalArgumentException("Invalid DB ! ");
        }

        handler.doBackup();
        handler.getConnection();

        DatabaseHandler factoryObj = DBFactoryProvider.getDBHandler(sql);
        factoryObj.doBackup();
        factoryObj.getConnection();

        // MANY EXAMPLES WOULD BE PaymentGateway like Stripe,Pay-pal,Jus-pay etc.,
        // NotificationService where we can send SMS,EMAIL,PUSH etc.,
        // LoggingService like SecurityLogging , NormalLogging, WarningLogger etc.,
        // A class which can be extended by multiple provider comes under here.
    }
}
