package spring6study.config_aop.javaConfigPrinciple;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDao getClientDao(){
        return clientDao;
    }

    @Override
    public void serve() {
        System.out.println("Client Service 실행...");
    }

}
