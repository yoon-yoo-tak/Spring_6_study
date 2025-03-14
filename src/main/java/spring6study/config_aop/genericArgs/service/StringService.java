package spring6study.config_aop.genericArgs.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class StringService implements GenericService<String>{

    @Override
    public void genericMethod(String param) {
        System.out.println("제네릭 메서드 실행 : " + param);
    }

    @Override
    public void genericCollectionMethod(Collection<String> param) {
        System.out.println("제네릭 메서드 실행 ( 원소 개수 : "+param.size()+")");
    }
    public void execute() {
        genericMethod("Hello AOP");

        List<String> list = Arrays.asList("Spring", "AOP", "Generic");
        genericCollectionMethod(list);
    }

}
