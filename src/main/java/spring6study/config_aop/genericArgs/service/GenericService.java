package spring6study.config_aop.genericArgs.service;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface GenericService<T> {
    public void genericMethod(T param);

    public void genericCollectionMethod(Collection<T> param);
}
