package com.example.about_proxy.step2_aop_transaction;

import java.sql.Connection;
import java.sql.DriverManager;

public class TransactionManager {
    public static void begin() throws Exception{
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        conn.setAutoCommit(false);
        ConnectionHolder.set(conn);
        System.out.println("트랜잭션 시작");
    }

    public static void commit() throws Exception{
        Connection conn = ConnectionHolder.get();
        conn.commit();
        conn.close();
        ConnectionHolder.clear();
        System.out.println("트랜잭션 커밋");
    }

    public static void rollback() throws Exception{
        Connection conn = ConnectionHolder.get();
        if (conn != null){
            conn.rollback();
            conn.close();
            ConnectionHolder.clear();
            System.out.println("트랜잭션 롤백");
        }
    }
}
