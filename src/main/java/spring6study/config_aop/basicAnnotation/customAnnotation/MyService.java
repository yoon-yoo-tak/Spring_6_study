package spring6study.config_aop.basicAnnotation.customAnnotation;

@MyComponent(value = "customBean", role = "admin")
public class MyService {
    public void execute(){
        System.out.println("Myservice execute");
    }
}
