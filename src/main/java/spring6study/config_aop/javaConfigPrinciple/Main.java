package spring6study.config_aop.javaConfigPrinciple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // clientService1, clientService2에서 같은 clientDao 인스턴스를 사용?
        ClientService service1 = context.getBean("clientService1", ClientService.class);
        ClientService service2 = context.getBean("clientService2", ClientService.class);

        System.out.println("clientService1의 ClientDao: " + service1.getClientDao());
        System.out.println("clientService2의 ClientDao: " + service2.getClientDao());


        System.out.println("같은 ClientDao 인스턴스를 사용하는가? " +
                (service1.getClientDao() == service2.getClientDao()));
    }
}
