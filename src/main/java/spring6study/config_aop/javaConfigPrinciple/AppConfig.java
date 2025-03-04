package spring6study.config_aop.javaConfigPrinciple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ClientService clientService1() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());  // clientDao() 호출
        return clientService;
    }

    @Bean
    public ClientService clientService2() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());  // clientDao() 호출
        return clientService;
    }

    @Bean
    public ClientDao clientDao() {
        System.out.println("ClientDaoImpl 객체 생성!");
        return new ClientDaoImpl();
    }
}
