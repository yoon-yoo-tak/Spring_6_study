package com.example.about_proxy.step2_aop_transaction;

import java.sql.Connection;

public class ConnectionHolder {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    public static void set(Connection connection) {
        connectionHolder.set(connection);
    }

    public static Connection get(){
        return connectionHolder.get();
    }

    public static void clear(){
        connectionHolder.remove();
    }
}
