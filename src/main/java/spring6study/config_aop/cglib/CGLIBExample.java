package spring6study.config_aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBExample {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ClientService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("[LOG] 메서드 호출 : " + method.getName());
                return proxy.invokeSuper(obj, args);
            }
        });

        ClientService service = (ClientService) enhancer.create();
        service.serve();
    }
}



class ClientService{
    public void serve(){
        System.out.println("ClientService 실행...");
    }
}