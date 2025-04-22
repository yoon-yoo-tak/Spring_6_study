package com.example.about_proxy.step1_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        MemberService target = new MemberServiceImpl();
        // 인터페이스 기반 프록시

        MemberService proxy = (MemberService) Proxy.newProxyInstance(
                MemberService.class.getClassLoader(), // 어떤 클래스 로더 쓸건지
                new Class[]{MemberService.class}, // 어떤 인터페이스 구현할건지
                // Method 호출하면 InvocationHandler의 invoke()로 강제 위임됨
                new InvocationHandler() {  // 메소드 호출하면 여기로 들어감
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("[JDK 프록시] 호출 전");
                        Object result = method.invoke(target, args);
                        System.out.println("[JDK 프록시] 호출 후");
                        return result;
                    }
                }
        );
        proxy.hello("Yoo Tak");
        /**
         * 실행 흐름
         *
         * proxy.hello("Yoo Tak")
         *     ↓
         * invoke(proxy, hello, [Yoo Tak]) 호출됨
         *     ↓
         * invoke 안에서 원본 target.hello() 호출
         *     ↓
         * invoke 끝나고 return
         *
         * JVM이 내부적으로 만드는 클래스(예시)
         *
         * class Proxy$MemberServiceImpl implements MemberService {
         *     InvocationHandler h;
         *
         *     String hello(String name) {
         *         return (String) h.invoke(this, helloMethod, new Object[]{name});
         *     }
         * }
         */
    }
}
