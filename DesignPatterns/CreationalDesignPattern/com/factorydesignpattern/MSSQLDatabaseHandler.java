package com.factorydesignpattern;

public class MSSQLDatabaseHandler extends DatabaseHandler{

    public MSSQLDatabaseHandler(String url , String username,String password) {
        super(url,username,password);
    }
    @Override
    public void doBackup() {
        System.out.println("MSSQL Backup uses .bak format and mssql specific implementation..");
    }

    @Override
    public Object getConnection() {
        System.out.println("Going to create connection with jdbc://sqlserver for user : "+userName);
        return null;
    }
}
