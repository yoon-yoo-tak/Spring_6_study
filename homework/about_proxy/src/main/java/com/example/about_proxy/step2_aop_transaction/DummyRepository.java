package com.example.about_proxy.step2_aop_transaction;

public class DummyRepository {
    public void save(String name) {
        System.out.println("DB에 저장: " + name);
    }
}