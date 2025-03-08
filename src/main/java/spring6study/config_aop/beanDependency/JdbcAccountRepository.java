package spring6study.config_aop.beanDependency;

class JdbcAccountRepository implements AccountRepository {
    @Override
    public void save() {
        System.out.println("Saving account to JDBC repository");
    }
}
