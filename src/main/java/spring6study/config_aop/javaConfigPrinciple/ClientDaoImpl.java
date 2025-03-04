package spring6study.config_aop.javaConfigPrinciple;

public class ClientDaoImpl implements ClientDao {

    @Override
    public void query() {
        System.out.println("DB 조회 실행...");
    }
}
