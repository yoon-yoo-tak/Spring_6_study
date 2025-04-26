package com.example.microsns.repository;

import java.sql.Connection;

public class ConnectionHolder {
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static void set(Connection connection) {
        threadLocal.set(connection);
    }

    public static Connection get() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}