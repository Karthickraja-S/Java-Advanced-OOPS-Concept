package com.factorydesignpattern;

public abstract class DatabaseHandler {
    public final String url;
    public final String userName;
    public final String password;
    public DatabaseHandler(String url, String userName,String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
    public abstract void doBackup();
    public abstract Object getConnection();
}
