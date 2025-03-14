package spring6study.config_aop.autowired.customAnnotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MyComponent {

    @AliasFor(annotation = Component.class, attribute = "value")
    String value() default "";

    String role() default "default-role";
}
