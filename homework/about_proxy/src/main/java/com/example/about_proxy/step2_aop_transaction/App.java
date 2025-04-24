package com.example.about_proxy.step2_aop_transaction;

public class App {
    public static void main(String[] args) {
        MemberService target = new MemberServiceImpl();
        MemberService service = (MemberService) TransactionProxy.newProxy(target);
        System.out.println("=== 정상 케이스 ===");
        service.register("tak");

        System.out.println("=== 예외 케이스 ===");
        try{
            service.register("error");
        }catch (Exception e){
            System.out.println("롤백됨");
        }
    }

    /**
     *  코드 실행 흐름
     * [main]
     *   |
     *   v
     * [TransactionProxy.newProxy(target)] - 생성
     *   |
     *   v
     * [프록시.register("tak")] - 호출
     *   |
     *   v
     * [invoke()] - 프록시가 가로챔
     *   |
     *   v
     * [MyTransactional 있음 → 트랜잭션 시작]
     *   |
     *   v
     * [target.register()] 실행
     *   |
     *   v
     * [DB 저장 로직 실행]
     *   |
     *   v
     * [성공 → 트랜잭션 커밋]
     */

}
