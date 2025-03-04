package spring6study.config_aop.beanDependency;

import javax.sql.DataSource;

public class JdbcAccountRepository implements AccountRepository {
    private final DataSource dataSource;

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void updateAccount(String accountId, double amount) {
        System.out.println("Updating account " + accountId + " by " + amount);
        // 실제로는 JDBC 코드가 들어갈 부분
    }
}