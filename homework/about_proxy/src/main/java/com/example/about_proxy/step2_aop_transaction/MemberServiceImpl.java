package com.example.about_proxy.step2_aop_transaction;

public class MemberServiceImpl implements MemberService {
    private final DummyRepository repo = new DummyRepository();

    @Override
    @MyTransactional
    public void register(String name){
        System.out.println("회원 등록 중 : " + name);
        repo.save(name);
        if (name.equals("error")) throw new IllegalArgumentException("에러 발생");
    }
}
