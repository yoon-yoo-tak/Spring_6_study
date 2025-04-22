package com.example.about_proxy.step1_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxyTest {
    public static void main(String[] args) {
        MemberServiceImpl target = new MemberServiceImpl();

        MemberServiceImpl proxy = (MemberServiceImpl) Enhancer.create(
                MemberServiceImpl.class, // 어떤 클래스를 상속할건지
                new MethodInterceptor() { // 메소드 호출하면 여기로 들어감
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        System.out.println("[CGLIB 프록시] 호출 전");
                        Object result = methodProxy.invoke(target, args);
                        System.out.println("[CGLIB 프록시] 호출 후");
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
         * intercept(proxy, hello, [Yoo Tak], methodProxy) 호출됨
         *     ↓
         * intercept 안에서 methodProxy.invoke(target, args) 호출
         *     ↓
         * intercept 끝나고 return
         *
         * 내부적으로 만들어지는 클래스(예시)
         * class MemberServiceImpl$$EnhancerByCGLIB extends MemberServiceImpl {
         *     MethodInterceptor interceptor;
         *
         *     @Override
         *     String hello(String name) {
         *         return (String) interceptor.intercept(this, helloMethod, new Object[]{name}, methodProxy);
         *     }
         * }
         */
    }
}