package com.factorydesignpattern;

public class DBFactoryProvider {
    public static DatabaseHandler getDBHandler(String database) {
        DatabaseHandler handler;
        if(database.equalsIgnoreCase("pgsql")) {
            handler = new PGSQLDatabaseHandler("localhost:2000","admin","admin");
        } else if(database.equalsIgnoreCase("mssql")) {
            handler = new MSSQLDatabaseHandler("localhost:3000","admin","admin");
        } else {
            throw new IllegalArgumentException("Invalid DB ! ");
        }
        return handler;
    }
}
