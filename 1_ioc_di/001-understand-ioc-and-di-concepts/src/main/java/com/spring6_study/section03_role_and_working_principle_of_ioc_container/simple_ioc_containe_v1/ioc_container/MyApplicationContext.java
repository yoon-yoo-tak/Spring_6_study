package com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.ioc_container;


import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.annotation.MyAutowired;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.annotation.MyComponent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyApplicationContext {

    private Map<Class<?>, Object> beanContainer = new HashMap<>();

    public MyApplicationContext(Class<?>... componentClasses) {

        // 1단계 : @MyComponent 애노테이션이 붙은 클래스의 인스턴스 생성 (생성자 주입)
        for (Class<?> clazz : componentClasses) {
            if (clazz.isAnnotationPresent(MyComponent.class)) {
                Object instance = createInstance(clazz);
                beanContainer.put(clazz, instance);
            }
        }

        // 2단계 : @MyAutowired가 붙은 필드를 찾아서 의존성 주입 (필드 주입)
        for (Object bean : beanContainer.values()) {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(MyAutowired.class)) {
                    Class<?> dependencyType = field.getType();
                    Object dependency = beanContainer.get(dependencyType);
                    if (dependency != null) {
                        field.setAccessible(true);
                        try {
                            field.set(bean, dependency);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("의존성 주입 실패");
                        }
                    } else {
                        throw new RuntimeException("의존성 주입 실패");
                    }
                }
            }
        }

        // 3단계 : @MyAutowired가 붙은 Setter 메서드를 찾아서 의존성 주입 (세터 주입)
        for (Object bean : beanContainer.values()) {
            Method[] declaredMethods = bean.getClass().getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(MyAutowired.class)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new RuntimeException("@MyAutowired가 붙은 세터는 반드시 하나의 파라미터를 가져야합니다.");
                    }
                    Object dependency = beanContainer.get(parameterTypes[0]);
                    if (dependency == null) {
                        throw new RuntimeException("의존성 주입 실패");
                    }
                    method.setAccessible(true);
                    try {
                        method.invoke(bean, dependency);
                    } catch (Exception e) {
                        throw new RuntimeException("의존성 주입 실패");
                    }
                }
            }
        }
    }

    public Object createInstance(Class<?> clazz) {
        try {
            // @MyAutowired 애노테이션이 붙은 생성자를 찾는다.
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            Constructor<?> injectionConstructor = null;

            for (Constructor<?> constructor : constructors) {
                if (constructor.isAnnotationPresent(MyAutowired.class)) {
                    injectionConstructor = constructor;
                    break;
                }
            }

            // 만약 못찾았다면 기본 생성자를 가져와서 인스턴스를 생성한다.
            if (injectionConstructor == null) {
                injectionConstructor = clazz.getDeclaredConstructor();
                injectionConstructor.setAccessible(true);
                return injectionConstructor.newInstance();
            }

            // 생성자 파라미터들에 해당하는 빈들을 찾아서 주입하여 인스턴스를 생성한다.
            Class<?>[] parameterTypes = injectionConstructor.getParameterTypes();
            Object[] params = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Object dependency = beanContainer.get(parameterTypes[i]);
                if (dependency == null) {
                    // 아직 생성되지 않은 의존성이 있다면 재귀적으로 생성을 시도한다.
                    dependency = createInstance(parameterTypes[i]);
                    beanContainer.put(parameterTypes[i], dependency);
                }
                params[i] = dependency;
            }
            injectionConstructor.setAccessible(true);
            return injectionConstructor.newInstance(params);
        } catch (Exception e) {
            throw new RuntimeException("의존성 주입 실패");
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(beanContainer.get(clazz));
    }
}
