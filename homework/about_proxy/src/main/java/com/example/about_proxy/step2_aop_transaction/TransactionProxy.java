package com.example.about_proxy.step2_aop_transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionProxy implements InvocationHandler {

    private final Object target;

    public TransactionProxy(Object target) {
        this.target = target;
    }

    public static Object newProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TransactionProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(MyTransactional.class)) {
            try{
                TransactionManager.begin();
                Object result = method.invoke(target, args);
                TransactionManager.commit();
                return result;
            }catch (Exception e){
                TransactionManager.rollback();
                throw e;
            }
        }else{
            return method.invoke(target, args);
        }
    }
}
