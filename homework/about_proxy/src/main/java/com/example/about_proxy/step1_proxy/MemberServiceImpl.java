package com.example.about_proxy.step1_proxy;

public class MemberServiceImpl implements MemberService {
    @Override
    public String hello(String name){
        System.out.println("MemberServcieImpl 호출");
        return "Hello " + name;
    }
}
